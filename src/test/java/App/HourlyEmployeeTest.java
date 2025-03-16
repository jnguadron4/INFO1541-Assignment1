package App;

import EmployeeObjects.HourlyEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourlyEmployeeTest {

    HourlyEmployee emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);



    @Test
    void addingHoursShouldIncreaseTotal() {
        // Add 5 hours
        emp.increaseHours(5);

        // Check if the total is correct
        assertEquals(5.0, emp.getHoursWorked());

        // add a negative number
        emp.increaseHours(-4);
        assertEquals(5, emp.getHoursWorked());

        // Add two different amounts of hours
        emp.increaseHours(2.4);

        // Check if total is correct
        assertEquals(7.4, emp.getHoursWorked());

    }

    @Test
    void wageShouldIncreaseByFivePercent() {
        // Call the annual raise method
        emp.annualRaise();

        // Expected wage after a 5% raise
        double expectedWage = 34.49;

        // Check if the new wage is correct
        assertEquals(expectedWage, emp.getWage());
    }


    @Test
    void weeklyPayFor35HoursShouldBeCorrect() {
        // Set hours to 35 (No overtime)
        emp.increaseHours(35);
        // Expected weekly pay: 35 * $32.85 = $1149.75
        double expectedPay = 1149.75;

        assertEquals(expectedPay, emp.calculateWeeklyPay());
    }


    @Test
    void weeklyPayFor45HoursShouldIncludeOvertime() {
        // Set hours to 45 (Overtime applies)
        emp.increaseHours(45);

        // Expected weekly pay:
        // 40 * $32.85 + (5 * ($32.85 * 1.5))
        // = 1314.00 + 246.38 = $1560.38
        double expectedPay = 1560.38;
        double actualPay = Math.round(emp.calculateWeeklyPay() * 100.0) / 100.0;
        assertEquals(expectedPay, actualPay);

    }

}
