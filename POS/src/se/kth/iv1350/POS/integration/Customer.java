package se.kth.iv1350.POS.integration;

/**
 *
 * @author Martin Nylund
 */
public class Customer {
    private String name;
    
    /**
     * Creates an instance of a customer, only identified by name. 
     * @param name 
     */
    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
