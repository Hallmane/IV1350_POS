package IV1350_seminar_3.model;

public interface TotalRevenueObserver {
    /**
     * Invoked when a sale has been completed.
     * @param totalPayment is the total generated from the current sale.
     */
    void newPayment(float totalPayment);

}
