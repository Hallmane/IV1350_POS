package IV1350_seminar_3.model;

public class Register {
    private float amountInRegister;

    /**
     * deposits the payment from the customer into the register
     * @param payment as payment
     */
    public void depositPayment(float payment) {
        amountInRegister += payment;
    }

    public float getBalance() {
        return amountInRegister;
    }
}
