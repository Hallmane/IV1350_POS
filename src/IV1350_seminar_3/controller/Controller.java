package IV1350_seminar_3.controller;

import IV1350_seminar_3.DTOs.ItemDTO;
import IV1350_seminar_3.integration.ItemDatabase;
import IV1350_seminar_3.integration.Printer;
import IV1350_seminar_3.integration.ServerErrorException;
import IV1350_seminar_3.view.TotalRevenueFileOutput;
import IV1350_seminar_3.model.*;
import IV1350_seminar_3.util.ErrorMessageHandler;
import IV1350_seminar_3.util.LogHandler;

/**
 * the Controller class which is responsible for calling the methods needed
 */
public class Controller {
    private Sale sale;
    private SaleLog saleLog = new SaleLog();
    private ItemDatabase itemDatabase  = new ItemDatabase();
    private Printer printer = new Printer();
    private Register register = new Register();

    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
    private LogHandler logHandler = new LogHandler();
    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();

    /**
     * creates the DTO for the type Item
     * @param itemID an ID for the item of type int
     * @param quantity how many of the items, of type int
     * @return the itemDTO
     */
    public ItemDTO itemScan(int itemID, int quantity) { //find item in item database
        Item scannedItem = null;
        try {
            scannedItem = itemDatabase.getItemByID(itemID, quantity);
        }
        catch(NoItemIDException e) {
            logHandler.logErrorMessage(e);
            errorMessageHandler.showErrorMessage(e.getMessage());
            return null;
        }
        catch(InvalidQuantityException e) {
            logHandler.logErrorMessage(e);
            errorMessageHandler.showErrorMessage(e.getMessage());
            return null;
        }
        catch(ServerErrorException e) {
            logHandler.logErrorMessage(e);
            errorMessageHandler.showErrorMessage(e.getMessage());
            return null;
        }

        sale.addItemToSale(scannedItem);
        return new ItemDTO(scannedItem);
    }

    /**
     * empties a new sale object
     */
    public void startSale() {
        sale = new Sale();
    }

    /**
     * ends sale by: calling the endSale method in the Sale object
     * calls on endSale method in sale
     * @return a float of the final price, finalPrice
     */
    public float endSale() {
        sale.endSale();
        float finalPrice = sale.endSale();
        return finalPrice;
    }

    /**
     *      creating a new receipt object
     *      logging the sale using the addToSaleLog method
     *      printing the receipt using the printReceipt method in the Receipt class
     */
    public void finish(){
        Receipt receipt = new Receipt(sale);
        saleLog.addToSaleLog(sale);
        itemDatabase.updateItemDatabase();
        printer.printReceipt(receipt);
    }

    public float getRunningTotal() {
        return sale.getRunningTotal(); 
    }

    /**
     * calls upon the register to deposit payment.
     * @param payment is the amount to be deposited.
     */
    public void depositAmountPaid(float payment) {
        register.depositPayment(payment);
    }

    /**
     * Registers a new TotalRevenueObserver to receive notice about changes in total revenue
     * @param totalRevenueObserver is the observer added.
     */
    public void addTotalPaymentObserver(TotalRevenueObserver totalRevenueObserver) {
        register.addTotalPaymentObservers(totalRevenueObserver);
    }
}
