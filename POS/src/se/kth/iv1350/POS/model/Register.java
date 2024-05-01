package se.kth.iv1350.POS.model;

/**
 *
 * @author Martin Nylund
 */
public class Register {
    static Amount amount = new Amount(0, "kr");
    
    /**
     * Add amount to the register. 
     * @param toAdd The amount to add to the register. 
     */
    public static void addTo(Amount toAdd) {
        amount = new Amount(amount.getAmount() + toAdd.getAmount(), "kr");
    }
}
