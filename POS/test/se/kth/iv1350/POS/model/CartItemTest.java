package se.kth.iv1350.POS.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.POS.integration.ItemDescriptionDTO;

/**
 *
 * @author Martin Nylund
 */
public class CartItemTest {

    private CartItem instance;
    private ItemDescriptionDTO item;

    public CartItemTest() {
    }

    @BeforeEach
    public void setUp() {
        item = new ItemDescriptionDTO(75, 52, "Papaya");
        instance = new CartItem(item);
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getItemDescriptionDTO method, of class CartItem.
     */
    @Test
    public void testGetItemDescriptionDTO() {
        ItemDescriptionDTO expResult = new ItemDescriptionDTO(75, 52, "Papaya");
        ItemDescriptionDTO result = instance.getItemDescriptionDTO();
        assertEquals(expResult, result, "The itemDescriptionDTO returned is not the same. ");
    }

    /**
     * Test of increaseItemQuantity method, of class CartItem.
     */
    @Test
    public void testIncreaseItemQuantity() {
        int quantity = 5;
        instance.increaseItemQuantity(quantity);
        int expResult = quantity;
        int result = instance.getQuantity();
        assertEquals(expResult, result, "The quantity returned is not the same. ");
    }

    /**
     * Test of getQuantity method, of class CartItem.
     */
    @Test
    public void testQuantity() {
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result, "The quantity returned is not the same. ");
    }

}
