package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.model.*;

/**
 *
 * @author Martin Nylund
 */
public class Controller {

    private Sale sale;

    /**
     * Starts a new sale. Must be called before that happens, also creates a
     * customer.
     */
    public void startSale() {
        sale = new Sale();
    }

    /**
     * Searches for the item in the inventory by communication with the
     * inventorys system, then creates a cartItem. 
     */
    public ItemDescriptionDTO searchItem(String identifier) {
        return InventorySystem.checkIfItemExists(identifier);
    }

    /**
     * Registers however many of the item searched for in the instance of the
     * sale, if it exists in the inventory.
     */
    public void registerItem(ItemDescriptionDTO item, int quantity) {
        if (item != null) {
            sale.addItem(item, quantity);
        } else {
            //Identifier invalid. 
        }
    }

    /**
     * Searches in the discount database for any elegible discount the current
     * customer has.
     */
    public Discount checkForDiscount(Customer customer) {
        return DiscountSystem.searchForElegibleDiscount(customer);
    }

    /**
     * When the customer wants to complete the transaction, they must pay an amount, and if they have a discount, it can be applied. 
     * @param amount
     * @param discount 
     */
    public Receipt pay(Amount amount, Discount discount) {      
        return sale.pay(amount, discount);
    }
    
    
}
