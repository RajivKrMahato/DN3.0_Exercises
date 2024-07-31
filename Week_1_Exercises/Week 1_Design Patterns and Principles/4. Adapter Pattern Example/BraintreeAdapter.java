public class BraintreeAdapter implements PaymentProcessor {
    private Braintree braintree;

    public BraintreeAdapter(Braintree braintree) {
        this.braintree = braintree;
    }

    public void processPayment(double amount) {
        braintree.submitPayment(amount);
    }
}
