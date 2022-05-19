package IV1350_seminar_3.model;

        import IV1350_seminar_3.integration.ItemDatabase;
        import IV1350_seminar_3.model.Item;
        import IV1350_seminar_3.model.NoItemIDException;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class NoItemIDExceptionTest {
    ItemDatabase itemDatabase;
    private Item invalidItem;
    private int invalidItemID = 1337;
    private int quantity = 3;

    @BeforeEach
    void setUp() {
        itemDatabase = new ItemDatabase();
    }
    @Test
    void testNoItemIDException() {
        try {
            invalidItem = itemDatabase.getItemByID(invalidItemID, quantity);
            fail("Could get item not found in database.");
        } catch (NoItemIDException e) {
            assertTrue(invalidItem == null, "Invalid item ID not caught: item with ID " + invalidItemID + " not in inventory.");
        }
    }

    @AfterEach
    void tearDown() {
        itemDatabase = null;
    }
}