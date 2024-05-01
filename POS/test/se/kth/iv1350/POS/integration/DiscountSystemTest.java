package se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.POS.model.Amount;

/**
 *
 * @author Martin Nylund
 */
public class DiscountSystemTest {

    private DiscountSystem discountSystem;

    public DiscountSystemTest() {
    }

    @BeforeEach
    public void setUp() {
        discountSystem = new DiscountSystem();
    }

    @AfterEach
    public void tearDown() {
        discountSystem = null;
    }

    /**
     * Test of searchForElegibleDiscount method, of class DiscountSystem.
     */
    @Test
    public void testSearchForElegibleDiscount() {
        Customer customer = new Customer("Name");
        Amount amount = new Amount(200, "kr");
        Discount discount = new Discount(customer, 25, amount);
        DiscountSystem.addDiscount(discount);
        Discount expResult = new Discount(customer, 25, amount);
        Discount result = DiscountSystem.searchForElegibleDiscount(customer);
        assertEquals(expResult, result, "The discount returned is not the same. ");
    }

    @Test
    public void testSearchForElegibleDiscountNull() {
        Customer customer = new Customer("NameNoCustomerHas");
        Discount expResult = null;
        Discount result = DiscountSystem.searchForElegibleDiscount(customer);
        assertEquals(expResult, result, "The discount returned is not the same. ");
    }

    /**
     * Test of addDiscount method, of class DiscountSystem.
     */
    @Test
    public void testAddDiscount() {
        Customer customer = new Customer("Name");
        Amount amount = new Amount(200, "kr");
        Discount discount = new Discount(customer, 25, amount);
        DiscountSystem.addDiscount(discount);
        Discount expResult = new Discount(customer, 25, amount);
        Discount result = DiscountSystem.searchForElegibleDiscount(customer);
        assertEquals(expResult, result, "The discount returned is not the same. ");
    }

}
