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

}
