package EmployeeObjects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestingAnnotations {
    public static void main(String[] args) {
        // Let's create a few employees to test. These are just fake examples for now.
        HourlyEmployee hourlyEmp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
        SalaryEmployee salaryEmp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
        CommissionEmployee commissionEmp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);

        // We will count how many different employee types we have
        int typesOfEmployee = 0;

        // Let's check if each employee is marked with a special tag (annotation)
        if (hourlyEmp.getClass().isAnnotationPresent(EmployeeType.class)) {
            typesOfEmployee++; // If it's marked, we add 1 to our counter
        }
        if (salaryEmp.getClass().isAnnotationPresent(EmployeeType.class)) {
            typesOfEmployee++; // We do the same for salary employees
        }
        if (commissionEmp.getClass().isAnnotationPresent(EmployeeType.class)) {
            typesOfEmployee++; // And again for commission employees
        }

        // Let's print out how many employee types we have
        System.out.println("You have " + typesOfEmployee + " employee types");

        // Now, we will check each employee for specific tags on their pay rate and weekly pay calculation
        checkEmployeeAnnotations(hourlyEmp);
        checkEmployeeAnnotations(salaryEmp);
        checkEmployeeAnnotations(commissionEmp);
    }

    public static void checkEmployeeAnnotations(Object employee) {
        // Check the employee's fields for the PayRate annotation
        checkFieldsForPayRateAnnotation(employee, PayRate.class);

        // Check the employee's methods for the WeeklyPayCalculator annotation
        checkMethodsForWeeklyPay(employee, WeeklyPayCalculator.class);
    }


       //This method checks the employee's class to find any fields (like salary or hourly rate)
       //that are marked with a special tag (annotation).
       //If a field is marked with the PayRate annotation, it will print the employee's pay rate.

    private static void checkFieldsForPayRateAnnotation(Object employee, Class<? extends Annotation> annotationType) {
        // Get all the fields (variables) inside the employee's class
        Field[] employeeFields = employee.getClass().getDeclaredFields();

        // Loop through each field in the employee class
        for (Field field : employeeFields) {
            // Check if the field has the annotation we are looking for
            if (field.isAnnotationPresent(annotationType)) {
                try {
                    // Allow access to private fields so we can read their values
                    field.setAccessible(true);

                    // If the annotation is "PayRate", get the pay rate value and print it
                    if (annotationType == PayRate.class) {
                        double employeePayRate = (double) field.get(employee);
                        System.out.println("Employee pay rate: $" + employeePayRate);
                    }
                } catch (IllegalAccessException e) {
                    // Print an error message if something goes wrong
                    e.getMessage();
                }
            }
        }
    }



    //This method looks at an employee's class and checks if any of its methods (functions)
    //are marked with a special tag (annotation). If we find the WeeklyPayCalculator annotation,
    //we will call that method and print out the employee's weekly pay.

    private static void checkMethodsForWeeklyPay(Object employee, Class<? extends Annotation> annotationType) {
        // Get all the methods (functions) inside the employee's class
        Method[] employeeMethods = employee.getClass().getDeclaredMethods();

        // Loop through each method to check if it has the special annotation
        for (Method method : employeeMethods) {
            // If the method has the annotation we are looking for
            if (method.isAnnotationPresent(annotationType)) {
                try {
                    // The methods are already public, so we don’t actually need this line.
                    // I included it just to show that I know where it should go,
                    // but it's not necessary in this case.
                    // method.setAccessible(true);

                    // If the annotation is "WeeklyPayCalculator", call the method and print the result
                    if (annotationType == WeeklyPayCalculator.class) {
                        double weeklyPayAmount = (double) method.invoke(employee); // Run the method and get the weekly pay
                        System.out.println("Weekly pay for " + employee.getClass().getSimpleName() + ": $" + weeklyPayAmount);
                    }
                } catch (Exception e) {
                    // Print an error message if something goes wrong
                    e.getMessage();
                }
            }
        }
    }


}
