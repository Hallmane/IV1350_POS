package IV1350_seminar_3.model;

import IV1350_seminar_3.DTOs.ItemDTO;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * An object of type Sale
 */
public class Sale {
    private LocalTime timeOfSale;
    private ArrayList<Item> itemsInSale = new  ArrayList<Item>();

    /**
     * Adds objects of type Item to the ArrayList created
     * @param item is the item
     */
    public void addItemToSale(Item item) {
        itemsInSale.add(item);
    }

    /**
     * Calls upon the LocalTime object's method to find the current time
     */
    public void setSaleTime() {
         timeOfSale = LocalTime.now();
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
     * calls upon the setSaleTime method to create a timestamp
     * @return getRunningTotal, which then becomes the final price
     */
    public float endSale() {
        setSaleTime();
        return getRunningTotal();
    }

}











