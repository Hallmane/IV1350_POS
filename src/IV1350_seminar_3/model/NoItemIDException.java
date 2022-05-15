package IV1350_seminar_3.model;

/**
 * Exception class concerning item identifiers
 */
public class NoItemIDException extends RuntimeException {
    private int invalidItemID;

    /**
     *
     * @param invalidItemID is the parameter causing the exception
     */
    public NoItemIDException(int invalidItemID) {
        super("Item with ID: "+ invalidItemID +" could not be found.");
        this.invalidItemID = invalidItemID;
    }

    /**
     *
     * @return the identifier causing exception
     */
    public int getInvalidItemID(){
        return invalidItemID;
    }
}
