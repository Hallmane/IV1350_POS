package IV1350_seminar_3.model;

/**
 * Exception class that handles the case with invalid item quantity
 */
public class InvalidQuantityException extends RuntimeException{
    int quantity;

    /**
     *
     * @param quantity is the invalid parameter causing the exception
     */
    public InvalidQuantityException(int quantity) {
        super("Item has invalid quantity: " + quantity);
        this.quantity = quantity;
    }

    /**
     *
     * @return the quantity causing the exception
     */
    public int getInvalidQuantity() {
        return quantity;
    }
}
