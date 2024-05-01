package se.kth.iv1350.POS.integration;

/**
 *
 * @author Martin Nylund
 */
public class ItemDescriptionDTO {
    private double tax;
    private int price;
    private String identifier;
    
    /**
     * The neccesary attributes which every item has, tax is included in the price. 
     * @param tax
     * @param price
     * @param identifier 
     */
    public ItemDescriptionDTO(double tax, int price, String identifier) {
        this.tax = tax;
        this.price = price;
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
    
    public int getPrice() {
        return price;
    }

    public double getTax() {
        return tax;
    }
}
