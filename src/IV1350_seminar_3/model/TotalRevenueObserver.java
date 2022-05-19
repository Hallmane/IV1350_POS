package IV1350_seminar_3.model;

public interface TotalRevenueObserver {
    /**
     * interface for the observer class
     * @param totalPayment is the total generated from the current sale.
     */
    void newPayment(float totalPayment);

}
