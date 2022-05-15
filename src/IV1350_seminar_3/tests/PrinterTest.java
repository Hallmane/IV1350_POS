package IV1350_seminar_3.tests;

import IV1350_seminar_3.model.Item;
import IV1350_seminar_3.model.Sale;

class PrinterTest {
    private String printerTestObject;
    private Item testItem;
    private Sale sale;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        sale = new Sale();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void printReceipt() {
    }
}