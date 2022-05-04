package IV1350_seminar_3.view;

import IV1350_seminar_3.DTOs.ItemDTO;
import IV1350_seminar_3.controller.Controller;
import IV1350_seminar_3.model.Item;

import java.util.ArrayList;


/**
 * Representing the available functions of the POS
 */

public class View {
    private Controller controller;
    private int firstItemID = 1;
    private int firstItemQuantity = 7;
    private int secondItemID = 2;
    private int secondItemQuantity = 13;


    /**
     * Creates a new instance that uses the specified controller for 
     *      all calls to other layers.
     *
     * @param controller The controller to use for all calls to other
     *      layers.
     */

    public View(Controller controller) {
        this.controller = controller;
        predeterminedView();

    }

    /**
     * prints some text to the "display"
     * @param textToPrint is the String to be printed
     */
    public void printToDisplay(String textToPrint) {
        System.out.println(textToPrint);

    }

    /**
     * hardcoded version of the View that represents a cashier starting a sale and scanning items.
     */
    public void predeterminedView() {
        controller.startSale();

        ItemDTO firstItemDTO = controller.itemScan(firstItemID, firstItemQuantity);
        itemToPrint(firstItemDTO);
        ItemDTO secondItemDTO = controller.itemScan(secondItemID, secondItemQuantity);
        itemToPrint(secondItemDTO);

        float totalPrice = controller.endSale();
        controller.depositAmountPayed(totalPrice);

        controller.finish();
    }

    /**
     * uses the printToDisplay method to print data from the Items using the ItemDTO object
     * @param itemDTO is object that holds data about an object, item, of type Item
     */
    private void itemToPrint(ItemDTO itemDTO) {
        printToDisplay( itemDTO.getName() + " | " +
                itemDTO.getQuantity() + " x " + (itemDTO.getPrice()
                + itemDTO.getPrice()*itemDTO.getVAT()) + "\nRunning Total: "
                + controller.getRunningTotal());

    }

}





