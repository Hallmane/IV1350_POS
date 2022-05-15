package IV1350_seminar_3.tests;

import IV1350_seminar_3.model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item itemToTest1;
    Item itemToTest2;

    @BeforeEach
    void setUp() {
        itemToTest1 = new Item("ABC", 10f, 0.13f);
        itemToTest2 = new Item("ABC", 10f, 0.13f);
    }

    @Test
    void testEquals() {
        assertEquals(itemToTest1.toString(), itemToTest2.toString(), "Items not the same");
    }

    @AfterEach
    void tearDown() {
        itemToTest1 = null;
        itemToTest2 = null;
    }
}