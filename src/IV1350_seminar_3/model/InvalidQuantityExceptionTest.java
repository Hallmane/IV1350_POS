package IV1350_seminar_3.model;

import IV1350_seminar_3.integration.ItemDatabase;
import IV1350_seminar_3.model.InvalidQuantityException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidQuantityExceptionTest {
    ItemDatabase itemDatabase;
    private int itemID = 1;
    private int invalidQuantity = 0;
    private int minimumQuantity = 1;

    @BeforeEach
    void setUp() {
        itemDatabase = new ItemDatabase();
    }
    @Test
    void testInvalidQuantityException() {
        try {
            itemDatabase.getItemByID(itemID, invalidQuantity);
            fail("Could add items less than one.");
        } catch (InvalidQuantityException e) {
            assertTrue(minimumQuantity > invalidQuantity, "Invalid quantity of item not caught: Minimum quantity: "
            + minimumQuantity + " > actual quantity: " + invalidQuantity);
        }
    }

    @AfterEach
    void tearDown() {
        itemDatabase = null;
    }
}