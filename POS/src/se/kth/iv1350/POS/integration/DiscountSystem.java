package se.kth.iv1350.POS.integration;

import java.util.ArrayList;

/**
 *
 * @author Martin Nylund
 */
public class DiscountSystem {
    static ArrayList<Discount> availableDiscounts;
    
    /**
     * Initializes the ArrayList which stores the discounts. 
     */
    public DiscountSystem() {
        availableDiscounts = new ArrayList<Discount>();
    }
    
    /**
     * Searches for the customer in the discount database, which is handled by the DiscountSystem. If a discount is found, it is then returned.  
     * @param identifier
     * @return 
     */
    public static Discount searchForElegibleDiscount(Customer customer) {
        for (Discount d : availableDiscounts) {
            if (customer.getName().equals(d.getOwner().getName())) {
                return d;
            }
        }
        return null;
    }
    
    public static void addDiscount(Discount discount) {
        availableDiscounts.add(discount);
    }
}
