package se.kth.iv1350.POS.integration;

import java.util.ArrayList;
import se.kth.iv1350.POS.model.*;

/**
 *
 * @author Martin Nylund
 */
public class InventorySystem {
    
    static ArrayList<CartItem> availableItems;
    
    /**
     * Creates the inventory for the store, manually in this case for the test run. 
     */
    public InventorySystem() {
        availableItems = new ArrayList<CartItem>();
        CartItem item1 = new CartItem(new ItemDescriptionDTO(12.5, 5, "Apple"));
        item1.increaseItemQuantity(95);
        availableItems.add(item1);
        CartItem item2 = new CartItem(new ItemDescriptionDTO(12.5, 9, "Banana"));
        item1.increaseItemQuantity(73);
        availableItems.add(item2);
        CartItem item3 = new CartItem(new ItemDescriptionDTO(12.5, 6, "Citron"));
        item1.increaseItemQuantity(201);
        availableItems.add(item3);
    }

    /**
     * Searches for the items identifier in the inventory of items, in this case
     * represented by the list "availableItems". Returns the DTO for the item if
     * found.
     *
     * @param identifier What is used to identify the item, in this case the
     * name.
     * @return
     */
    public static ItemDescriptionDTO checkIfItemExists(String identifier) {
        for (CartItem c : availableItems) {
            if (identifier.equals(c.getItemDescriptionDTO().getIdentifier())) {
                return c.getItemDescriptionDTO();
            }
        }
        return null;
    }
    
    /**
     * Method for updating the inventory, when items are sold. 
     * Subtracting the quantity of the item sold from the quantity of the item in the inventory. 
     * @param sale 
     */
    public static void update(Sale sale) {
        for (CartItem c : sale.getCartItems()) {
            for (CartItem a : availableItems) {
                if (c.getItemDescriptionDTO().getIdentifier().equals(a.getItemDescriptionDTO().getIdentifier())) {
                    a.increaseItemQuantity(c.getQuantity() * -1);
                }
            }
        }
    }  
}
