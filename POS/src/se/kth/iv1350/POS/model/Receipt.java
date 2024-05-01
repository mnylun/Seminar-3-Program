package se.kth.iv1350.POS.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Martin Nylund
 */
public class Receipt {

    private LocalDateTime dateAndTime;
    private ArrayList<CartItem> boughtItems;
    private Amount totalSalePrice, totalTax, amountPaid, change;

    /**
     * All information about the sale is represented in the receipt.
     *
     * @param dateAndTime
     * @param boughtItems Contains the item as well as the quantity of the item.
     * @param totalSalePrice
     * @param totalTax
     * @param amountPaid
     * @param change
     */
    public Receipt(LocalDateTime dateAndTime, ArrayList<CartItem> boughtItems, 
            Amount totalSalePrice, Amount totalTax, Amount amountPaid, Amount change) {
        this.dateAndTime = dateAndTime;
        this.boughtItems = boughtItems;
        this.totalSalePrice = totalSalePrice;
        this.totalTax = totalTax;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    @Override
    public String toString() {
        String boughtItemsString = "";
        for (CartItem c : boughtItems) {
            boughtItemsString += "\nIdentifier: " + c.getItemDescriptionDTO().getIdentifier() + 
                    " x " + c.getQuantity() + "\tPrice: " + c.getItemDescriptionDTO().getPrice();
        }
        return "--------- Receipt ---------\n"
                + "Date and time:" + dateAndTime + "\n"
                + "Bought Items:" + boughtItemsString + "\n"
                + "Total Sale Price: " + totalSalePrice.getAmount() + "\n"
                + "Total Tax: " + totalTax.getAmount() + "\n"
                + "Amount Paid: " + amountPaid.getAmount() + "\n"
                + "Change: " + change.getAmount();
    }

}
