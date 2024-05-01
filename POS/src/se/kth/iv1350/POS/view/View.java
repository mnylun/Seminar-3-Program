package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.*;
import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.model.*;

/**
 *
 * @author Martin Nylund
 *
 * Placeholder for the real View class, this is not how it should be.
 */
public class View {

    private Controller controller;

    /**
     * Creates a new instance, uses controller for calls to all other layers.
     *
     * @param controller
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * This is a test, going through all of the system operations in the basic
     * and alternate flow of the retail store.
     */
    public void testRun() {
        controller.startSale();
        ItemDescriptionDTO item1 = controller.searchItem("Banana");
        ItemDescriptionDTO item2 = controller.searchItem("Apple");
        ItemDescriptionDTO item3 = controller.searchItem("Citron");
        controller.registerItem(item1, 5);
        controller.registerItem(item2, 3);
        controller.registerItem(item3, 11);

        Customer customer = new Customer("Bob");
        Discount discount = controller.checkForDiscount(customer);
        Amount payment = new Amount(500, "kr");

        Receipt receipt = controller.pay(payment, discount);
        if (receipt != null) {
            System.out.println(receipt.toString());
        }
    }
}
