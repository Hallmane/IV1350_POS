package IV1350_seminar_3.model;

import java.util.ArrayList;

/**
 * representation of sale logs
 */
public class SaleLog {
    private ArrayList<Sale> loggedSales = new ArrayList<Sale>();

    /**
     * appends a sale to the loggedSales variable
     * @param sale is the thing that is logged
     */
    public void addToSaleLog(Sale sale) {
        loggedSales.add(sale);
    }
}
