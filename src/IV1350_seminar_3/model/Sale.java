package IV1350_seminar_3.model;

import IV1350_seminar_3.DTOs.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * An object of type Sale
 */
public class Sale {
    private ArrayList<Item> itemsInSale = new  ArrayList<>();
    private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();

    /**
     * Adds objects of type Item to the ArrayList created
     *  If the name of the scanned item matches another item already in the sale, it will
     *      call upon the increaseItemQuantity to update the amount of that item in the sale.
     * @param item is the item scanned
     */
    public void addItemToSale(Item item) {

        for (int i=0; i< itemsInSale.size(); i++) {
            if(itemsInSale.get(i).getName().equals(item.getName())){
                increaseItemQuantity(item.getName(), item.getQuantity());
                return;
            }
        }

        itemsInSale.add(item);
    }

    /**
     * Calls upon the LocalTime object's method to find the current time
     */
    public void setSaleTime() {
         LocalTime.now();
    }

    /**
     * @return a float of the running total
     */
    public float getRunningTotal() {
        float total = 0;

        for(int i=0; i<itemsInSale.size(); i++) {
            total += (itemsInSale.get(i).getPrice() +
                itemsInSale.get(i).getPrice()*itemsInSale.get(i).getVAT())*itemsInSale.get(i).getQuantity();
        }
        return total;
    }

    /**
     * Notifies observers
     * @param finalTotal cool:-)
     */
    private void notifyObservers(float finalTotal) {
        for (TotalRevenueObserver totalRevenueObserver : totalRevenueObservers) {
            totalRevenueObserver.newPayment(finalTotal);
        }
    }
    public void addTotalPaymentObservers(List<TotalRevenueObserver> totalRevenueObservers) {
        totalRevenueObservers.addAll(totalRevenueObservers);
    }

    /**
     * copies the itemsInSale into a new array
     * @return an array of ItemDTO
     */
    public ItemDTO[] returnItemsDTO() {
        ItemDTO[] itemDTOCopy = new ItemDTO[itemsInSale.size()];
        for(int i=0; i< itemsInSale.size(); i++) {
            itemDTOCopy[i] = new ItemDTO(itemsInSale.get(i));
        }
        return itemDTOCopy;
    }

    /**
     *  Logic for increasing item quantity if same item type already exists in the current sale
     * @param name is the name of the item that is getting added
     * @param addedQuantity is the amount of the item type
     */
    public void increaseItemQuantity(String name, int addedQuantity){
        for(int i = 0; i < itemsInSale.size(); i++)
        {
            if(itemsInSale.get(i).getName().equals(name))
            {
                itemsInSale.get(i).setQuantity(itemsInSale.get(i).getQuantity() + addedQuantity);
                break;
            }
        }
    }

    /**
     * Calls upon the setSaleTime method to create a timestamp.
     * Sets the variable finalTotal to the getRunningTotal method, which sums the prices of items in basket.
     * Broadcasts finalTotal to all subscribers.
     * @return finalTotal.
     */
    public float endSale() {
        setSaleTime();
        float finalTotal = getRunningTotal();
        notifyObservers(finalTotal);
        return finalTotal;
    }
}











