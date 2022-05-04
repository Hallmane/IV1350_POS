package IV1350_seminar_3.DTOs;

import IV1350_seminar_3.model.Item;

/**
 * a DTO object to hold and send data about the Items
 */
public class ItemDTO {
    private String name;
    private float price;
    private float VAT;
    private int quantity;

    /**
     * the ItemDTO constructor
     * @param item which holds name, price, VAT, quantity
     */
    public ItemDTO(Item item) {

        name = item.getName();
        price = item.getPrice();
        VAT = item.getVAT();
        quantity = item.getQuantity();
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getVAT() {
        return VAT;
    }

    public int getQuantity() {
        return quantity;
    }
}














