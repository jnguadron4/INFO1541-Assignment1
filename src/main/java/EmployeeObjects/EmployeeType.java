package EmployeeObjects;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  // Makes the annotation available at runtime
public @interface EmployeeType {
    String type();  // String variable to hold the type of employee
}
