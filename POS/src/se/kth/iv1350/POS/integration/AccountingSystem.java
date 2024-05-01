package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.model.*;

/**
 *
 * @author Martin Nylund
 */
public class AccountingSystem {

    /**
     * Calculates the total price of a sale.
     *
     * @param sale
     * @return
     */
    public static Amount calculateTotalPrice(Sale sale) {
        int total = 0;
        for (CartItem c : sale.getCartItems()) {
            total += c.getItemDescriptionDTO().getPrice() * c.getQuantity();
        }
        return new Amount(total, "kr");
    }

    /**
     * Calculates the effective price after the discount is applied.
     *
     * @param price
     * @param discount
     * @return
     */
    public static Amount calculateEffectivePrice(Amount price, Discount discount) {
        return new Amount(price.getAmount() - price.getAmount() * discount.getPercentage() / 10 - discount.getAmount().getAmount(), "kr");
    }

    /**
     * Subtracts one amount from the other, which is the change.
     *
     * @param money
     * @param price
     * @return
     */
    public static Amount calculateChange(Amount money, Amount price) {
        return new Amount(money.getAmount() - price.getAmount(), "kr");

    }
    
    /**
     * Goes through each item in a sale, and adds all of the tax up from each item. 
     * @param sale
     * @return 
     */
    public static Amount calculateTotalTax(Sale sale) {
        double totalTax = 0;
        for (CartItem c : sale.getCartItems()) {
            totalTax += c.getItemDescriptionDTO().getPrice() * (c.getItemDescriptionDTO().getTax() / 10);
        }
        return new Amount((int) totalTax, "kr");
    }
}
