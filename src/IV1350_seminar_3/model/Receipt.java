
package IV1350_seminar_3.model;

import IV1350_seminar_3.DTOs.ItemDTO;

import java.time.LocalTime;

/**
 * creating a Receipt object
 */
public class Receipt {

    private String finalSale = "";

    /**
     * the constructor for the Receipt object.
     *      Adds the data from the sale object to a String
     *
     * @param sale needed to print the sale data
     */
    public Receipt(Sale sale){
        ItemDTO[] itemDTOs = sale.returnItemsDTO();
        finalSale += "\n[RECEIPT]\n";
        finalSale += "_________________________________\n";
        for(int i=0; i < itemDTOs.length; i++) {
            finalSale += itemDTOs[i].getName() + " "
             + (itemDTOs[i].getPrice() + itemDTOs[i].getPrice()*itemDTOs[i].getVAT()) + " x " +
             itemDTOs[i].getQuantity() + " \n";
        }
        finalSale += " Total: ";
        finalSale += sale.getRunningTotal(); // totalPrice
        finalSale += "\n" + getSaleTime();
        finalSale += "\n_________________________________";
    }

    /**
     * creating the toString method
     * @return string finalSale
     */
    public String toString() {
        return finalSale;
    }

    /**
     * calls the method now from LocalTime to add the time of sale
     * @return String of the time
     */
    private String getSaleTime() {
        return LocalTime.now().toString();
    }
}
