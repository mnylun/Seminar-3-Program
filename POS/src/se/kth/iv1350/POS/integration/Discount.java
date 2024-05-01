package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.model.*;

/**
 *
 * @author Martin Nylund
 */
public class Discount {
    private Customer owner;
    private int percentage;
    private Amount amount;

    /**
     * Creates a discount, which has two sorts of discounts, and one owner of the discount. 
     * @param owner The owner of the discount
     * @param percentage A percentage of the price is discounted. 
     * @param amount A amount is discounted of the price. 
     */
    public Discount(Customer owner, int percentage, Amount amount) {
        this.owner = owner;
        this.percentage = percentage;
        this.amount = amount;
    }

    public Customer getOwner() {
        return owner;
    }

    public int getPercentage() {
        return percentage;
    }

    public Amount getAmount() {
        return amount;
    }
}
