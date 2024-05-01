package se.kth.iv1350.POS.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import se.kth.iv1350.POS.integration.*;

/**
 *
 * @author Martin Nylund
 */
public class Sale {

    private LocalDateTime dateAndTime;
    private Receipt receipt;
    private ArrayList<CartItem> cartItems;

    /**
     * Creates an instance of a sale.
     */
    public Sale() {
        dateAndTime = LocalDateTime.now();
        cartItems = new ArrayList<CartItem>();
    }

    /**
     * Adds the item to the cart, or increases the quantity of it if it already
     * exists.
     *
     * @param itemDescriptionDTO The item to be registered.
     * @param quantity How many of the item to be registered.
     */
    public void addItem(ItemDescriptionDTO itemDescriptionDTO, int quantity) {
        if (itemAlreadyInCart(itemDescriptionDTO) == null) {
            cartItems.add(new CartItem(itemDescriptionDTO));
        }
        increaseQuantityOfItem(itemDescriptionDTO, quantity);
    }

    /**
     * Checks if the item already has been added to the cart, then returns the
     * corresponding item. If it is not, then retuns null.
     *
     * @param itemDescriptionDTO
     * @return
     */
    private CartItem itemAlreadyInCart(ItemDescriptionDTO itemDescriptionDTO) {
        for (CartItem c : cartItems) {
            if (itemDescriptionDTO == c.getItemDescriptionDTO()) {
                return c;
            }
        }
        return null;
    }

    /**
     * Increases the quantity of the corresponding item.
     *
     * @param itemDescriptionDTO The item to be increased.
     * @param quantity How many of the item.
     */
    public void increaseQuantityOfItem(ItemDescriptionDTO itemDescriptionDTO, int quantity) {
        CartItem selectedItem = itemAlreadyInCart(itemDescriptionDTO);
        selectedItem.increaseItemQuantity(quantity);
    }

    /**
     * The customer pays an amount, and if this amount is more than the cost of
     * the sale after the discount has been applied, the receipt is printed, the
     * amount paid is added to the register, and the trasaction is completed.
     *
     * @param amount
     * @param discount
     */
    public Receipt pay(Amount amount, Discount discount) {
        Amount totalCost = AccountingSystem.calculateTotalPrice(this);
        Amount effectivePrice = discount == null ? totalCost : AccountingSystem.calculateEffectivePrice(totalCost, discount);
        Amount change = AccountingSystem.calculateChange(amount, effectivePrice);

        if (change.getAmount() >= 0) {
            Register.addTo(effectivePrice);
            InventorySystem.update(this);
            return printReceipt(amount, totalCost, effectivePrice, change);
        }
        return null;
    }

    public Iterable<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * Prints the receipt, which is done when the transation is completed.
     *
     * @param amount The amount the customer paid.
     * @param totalCost The total cost of the sale.
     * @param effectivePrice The effective price of the sale, after discounts
     * have been accounted for.
     * @param change
     * @return
     */
    public Receipt printReceipt(Amount amount, Amount totalCost, Amount effectivePrice, Amount change) {
        receipt = new Receipt(dateAndTime, cartItems, totalCost,
                AccountingSystem.calculateTotalTax(this), amount, change);
        return receipt;
    }
}
