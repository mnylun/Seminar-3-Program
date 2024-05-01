package se.kth.iv1350.POS.model;

/**
 *
 * @author Martin Nylund
 */
public class Amount {
    private int amount;
    private String currency;

    /**
     * Creates an instance of the amount class, which has the amount, as well as what type of the currency the amount is in. 
     * @param amount
     * @param currency 
     */
    public Amount(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }
    
}
