package IV1350_seminar_3.model;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private float amountInRegister;
    private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();

    /**
     * deposits the payment from the customer into the register
     * @param payment as payment
     */
    public void depositPayment(float payment) {
        amountInRegister += payment;
        notifyObservers(payment);
    }

    public float getBalance() {
        return amountInRegister;
    }

    /**
     * Notifies observers about change in total revenue
     * @param finalTotal is a float of the new total revenue
     */
    private void notifyObservers(float finalTotal) {
        for (TotalRevenueObserver totalRevenueObserver : totalRevenueObservers) {
            totalRevenueObserver.newPayment(finalTotal);
        }
    }

    /**
     * Adds a TotalRevenueObserver to send notices to.
     * @param totalRevenueObserver is the observer to add.
     */
    public void addTotalPaymentObservers(TotalRevenueObserver totalRevenueObserver) {
        totalRevenueObservers.add(totalRevenueObserver);
    }
}













