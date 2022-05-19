package IV1350_seminar_3.view;

import IV1350_seminar_3.DTOs.ItemDTO;
import IV1350_seminar_3.controller.Controller;


/**
 * Representing the available functions of the POS
 */

public class View {
    private Controller controller;

    private int firstItemID = 1;
    private int firstItemQuantity = 7;

    private int secondItemID = 2;
    private int secondItemQuantity = 13;

    private int thirdItemID = 404;
    private int thirdItemQuantity = 3;

    private int fourthItemID = 1337;
    private int fourthItemQuantity = 1;

    private int fifthItemID = 1;
    private int fifthItemQuantity = -1;


    /**
     * Creates a new instance that uses the specified controller for 
     *      all calls to other layers.
     *
     * @param controller The controller to use for all calls to other
     *      layers.
     */
    public View(Controller controller) {
        this.controller = controller;
        controller.addTotalPaymentObserver(new TotalRevenueView());
        controller.addTotalPaymentObserver(new TotalRevenueFileOutput());
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

        ItemDTO thirdItemDTO = controller.itemScan(thirdItemID, thirdItemQuantity);
        itemToPrint(thirdItemDTO);

        ItemDTO fourthItemDTO = controller.itemScan(fourthItemID, fourthItemQuantity);
        itemToPrint(fourthItemDTO);

        ItemDTO fifthItemDTO = controller.itemScan(fifthItemID, fifthItemQuantity);
        itemToPrint(fifthItemDTO);

        float totalPrice = controller.endSale();
        controller.depositAmountPaid(totalPrice);
        controller.finish();
    }

    /**
     * uses the printToDisplay method to print data from the Items using the ItemDTO object
     * @param itemDTO is object that holds data about an object, item, of type Item
     */
    private void itemToPrint(ItemDTO itemDTO) {
        if(!(itemDTO==null)) {
            printToDisplay("[VIEW]\n" + itemDTO.getName() + " | " +
                    itemDTO.getQuantity() + " x " + (itemDTO.getPrice()
                    + itemDTO.getPrice() * itemDTO.getVAT()) + "\nRunning Total: "
                    + controller.getRunningTotal());
        }
    }
}





