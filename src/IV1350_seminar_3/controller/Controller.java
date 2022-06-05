package IV1350_seminar_3.controller;

import IV1350_seminar_3.DTOs.ItemDTO;
import IV1350_seminar_3.integration.ItemDatabase;
import IV1350_seminar_3.integration.Printer;
import IV1350_seminar_3.integration.ServerErrorException;
import IV1350_seminar_3.view.TotalRevenueFileOutput;
import IV1350_seminar_3.model.*;

/**
 * the Controller class which is responsible for calling the methods needed
 */
public class Controller {
    private Sale sale;
    private SaleLog saleLog = new SaleLog();
    private ItemDatabase itemDatabase  = new ItemDatabase();
    private Printer printer = new Printer();
    private Register register = new Register();

    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();

    /**
     * creates the DTO for the type Item
     * @param itemID an ID for the item of type int
     * @param quantity how many of the items, of type int
     * @return the itemDTO
     */
// Relocate this to Sale instead.
    public ItemDTO itemScan(int itemID, int quantity) { //find item in item database
        Item scannedItem = null;

        scannedItem = itemDatabase.getItemByID(itemID, quantity);

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
        //float finalPrice = sale.endSale();
        return sale.endSale();
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
    public void depositAmountPaid(float payment) {
        register.depositPayment(payment);
    }

    public void addTotalPaymentObserver(TotalRevenueObserver totalRevenueObserver) {
        register.addTotalPaymentObservers(totalRevenueObserver);
    }
}
