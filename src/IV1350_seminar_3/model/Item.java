package IV1350_seminar_3.model;

/**
 * an object of type Item holds a name, price, VAT and the quantity of it.
 */
public class Item {
    private String name;
    private float price;
    private float VAT;
    private int quantity;

    /**
     * The constructor for the Item class
     * @param name is an explainable string
     * @param price is the price as a float
     * @param VAT is a float
     */
    public Item(String name, float price, float VAT) {
        this.name = name;
        this.price = price;
        this.VAT = VAT;
    }

    /**
     * The constructor for creating copies of item objects
     * @param item to copy
     * @param quantity of item
     */
    public Item(Item item, int quantity) {
        name = item.getName();
        price = item.getPrice();
        this.quantity = quantity;
        VAT = item.getVAT();
    }

    public String toString() {
        return name + price + quantity + VAT;
    }



    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getVAT() {
        return VAT;
    }
    public void setQuantity(int quantity) {
        if(quantity > 0)
            this.quantity = quantity;
    }
}

