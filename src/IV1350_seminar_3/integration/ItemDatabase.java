package IV1350_seminar_3.integration;

import IV1350_seminar_3.model.Item;
import java.util.HashMap;

/**
 * Representing an external inventory system
 */
public class ItemDatabase {
    private HashMap<Integer, Item> itemHashMap = new HashMap<Integer, Item>();
    private final int appleID = 1;
    private final int magazineID = 2;

    private final String appleName = "Apple";
    private final String magazineName = "Hustler";

    private final float appleVATRate = 0.1f;
    private final float magazineVATRate = 0.25f;

    private final float applePrice = 10f;
    private final float magazinePrice = 39.90f;

    /**
     * Constructor for the object
     */
    public ItemDatabase(){
        fillInventorySystem();
    }

    /**
     * Creates a HashMap (inventory) with the final variables above
     */
    private void fillInventorySystem(){
        itemHashMap.put(appleID, new Item(appleName, applePrice, appleVATRate));
        itemHashMap.put(magazineID, new Item(magazineName, magazinePrice, magazineVATRate));
    }

    /**
     * Locates items in the HashMap by their specified ID and returns a copy of it as an Item object.
     * @param id is the specified ID of the item
     * @param quantity is the number of items
     * @return Item itemCopy
     */
    public Item getItemByID(int id, int quantity){
        Item itemCopy = new Item(itemHashMap.get(id), quantity);
        return itemCopy;
    }

    /**
     * Placeholder method for updating the inventory after the sale has ended.
     */
    public void updateItemDatabase() {
        System.out.println("Inventory updated.");
    }
}







