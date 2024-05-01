package se.kth.iv1350.POS.startup;

import se.kth.iv1350.POS.controller.*;
import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.view.*;

/**
 *
 * @author Martin Nylund
 * Starts the application, contains the Main method
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View(controller);
        //Initialize one instance of these systems here, are needed to run the constructors which are neccesary for the test run. 
        InventorySystem inventorySystem = new InventorySystem();
        DiscountSystem discountSystem = new DiscountSystem();
        view.testRun();
    }
    
}
