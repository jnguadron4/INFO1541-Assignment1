package App;

import EmployeeObjects.SalaryEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryEmployeeTest {

    SalaryEmployee emp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);



    @Test
    void weeklyPayShouldBeCalculatedCorrectly() {
        // Step 1: What we expect
        // Steve's yearly salary = $64,325
        // Weekly pay = 64,325 / 52 weeks
        // Expected result = 1,237.02
        double expectedPay = 1237.02;

        // Step 2: Get actual weekly pay from our method
        double actualPay = emp.calculateWeeklyPay();

        // Step 3: Round it to 2 decimal places (just in case)
        actualPay = Math.round(actualPay * 100.0) / 100.0;

        // Step 4: Check if the method works correctly
        assertEquals(expectedPay, actualPay);
    }

    @Test
    void holidayBonusShouldBeCalculatedCorrectly() {
        // Step 1: What we expect
        // Steve's yearly salary = $64,325
        // Bonus = 3.365% of salary = 64325 * 0.03365
        // Expected result = 2,164.54
        double expectedBonus = 2164.54;

        // Step 2: Get actual bonus from our method
        double actualBonus = emp.holidayBonus();

        // Step 3: Round it to 2 decimal places (just in case)
        actualBonus = Math.round(actualBonus * 100.0) / 100.0;
        expectedBonus = Math.round(expectedBonus * 100.0) / 100.0;

        // Step 4: Check if the method works correctly
        assertEquals(expectedBonus, actualBonus, "Steve's holiday bonus should be $2164.54.");
    }
}
