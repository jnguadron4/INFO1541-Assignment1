package EmployeeObjects;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  // Makes the annotation available at runtime
public @interface PayRate {
    String type();  // This will hold the type value, e.g., "Hourly", "Salary", "Commission"
}