package IV1350_seminar_3.tests;

import IV1350_seminar_3.integration.ItemDatabase;
import IV1350_seminar_3.integration.ServerErrorException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerErrorExceptionTest {
    ItemDatabase itemDatabase;
    private int errorItemID = 404;
    private int quantity = 3;

    @BeforeEach
    void setUp() {
        itemDatabase = new ItemDatabase();
    }
    @Test
    void testInvalidQuantityException() {
        try {
            itemDatabase.getItemByID(errorItemID, quantity);
            fail("Server exception not caught");
        } catch (ServerErrorException e) {
            assertTrue(e.isServerErrorExceptionHandled(), "Server exception caught despite no server error.");
        }
    }

    @AfterEach
    void tearDown() {
        itemDatabase = null;
    }
}