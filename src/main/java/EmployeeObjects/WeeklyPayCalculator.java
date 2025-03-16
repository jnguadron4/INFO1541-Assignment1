package EmployeeObjects;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  // Makes the annotation available at runtime
public @interface WeeklyPayCalculator {
    // No variables needed for this annotation
}