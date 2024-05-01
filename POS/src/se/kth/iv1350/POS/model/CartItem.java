package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.integration.*;

/**
 *
 * @author Martin Nylund
 */
public class CartItem {
    private ItemDescriptionDTO itemDescriptionDTO;
    private int quantity;

    /**
     * Creates an instance of the cartItem class, which refers to one or multiple of the same item the customer has in their cart. 
     * @param itemDescriptionDTO
     * @param quantity 
     */
    public CartItem(ItemDescriptionDTO itemDescriptionDTO) {
        this.itemDescriptionDTO = itemDescriptionDTO;
        this.quantity = 0;
    }
    
    public ItemDescriptionDTO getItemDescriptionDTO() {
        return itemDescriptionDTO;
    }

    public void increaseItemQuantity(int quantity) {
        this.quantity += quantity;
    }    

    public int getQuantity() {
        return quantity;
    }
}
