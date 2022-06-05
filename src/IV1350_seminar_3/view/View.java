package IV1350_seminar_3.view;

import IV1350_seminar_3.DTOs.ItemDTO;
import IV1350_seminar_3.controller.Controller;
import IV1350_seminar_3.integration.ServerErrorException;
import IV1350_seminar_3.model.InvalidQuantityException;
import IV1350_seminar_3.model.NoItemIDException;
import IV1350_seminar_3.util.ErrorMessageHandler;
import IV1350_seminar_3.util.LogHandler;


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

    private LogHandler logHandler = new LogHandler();
    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();

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

    public void predeterminedView() {
        firstSale();
    }

    private void tryAddItem(int itemID, int itemQuantity) {
        try {
            ItemDTO firstItemDTO = controller.itemScan(itemID, itemQuantity);
            itemToPrint(firstItemDTO);
            }
        catch(NoItemIDException e) {
            logHandler.logErrorMessage(e);
            errorMessageHandler.showErrorMessage("Could not add item with ID " + e.getInvalidItemID()+ ". ");
        }
        catch(InvalidQuantityException e) {
            logHandler.logErrorMessage(e);
            errorMessageHandler.showErrorMessage("Invalid quantity: \" "+e.getInvalidQuantity()+"\".");
        }
        catch(ServerErrorException e) {
            logHandler.logErrorMessage(e);
            errorMessageHandler.showErrorMessage("Could not reach the server.");
        }
    }

    /**
     * hardcoded version of the View that represents a cashier starting a sale and scanning items.
     */
    private void firstSale() {
        controller.startSale();

        tryAddItem(firstItemID, firstItemQuantity);
        tryAddItem(secondItemID, secondItemQuantity);
        tryAddItem(thirdItemID, thirdItemQuantity);
        tryAddItem(fourthItemID, fourthItemQuantity);

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





