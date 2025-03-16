package App;


import EmployeeObjects.CommissionEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommissionEmployeeTest {
    CommissionEmployee emp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);

    @Test
    void increaseSalesShouldOnlyAddPositiveValues() {
        // Step 1: Add a positive sales amount
        emp.increaseSales(5000);

        // Step 2: Check that sales increased by 5000
        assertEquals(5000, emp.getSales());

        // Step 3: Add a negative sales amount (should not change sales)
        emp.increaseSales(-1000);

        // Step 4: Check that sales have not changed
        assertEquals(5000, emp.getSales());

        // Step 5: Add another positive sales amount
        emp.increaseSales(3000);

        // Step 6: Check that sales increased by 3000
        assertEquals(8000, emp.getSales());
    }

    @Test
    void holidayBonusShouldBeZeroForCommissionEmployee() {
        // Step 1: Check that the holiday bonus is 0 for commission employees
        double expectedBonus = 0;
        // Step 2: Check if the holiday bonus is correctly returned as 0
        assertEquals(expectedBonus, emp.holidayBonus());
    }

}
