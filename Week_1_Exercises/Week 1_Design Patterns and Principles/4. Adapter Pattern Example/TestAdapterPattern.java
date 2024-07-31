public class TestAdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor braintreeProcessor = new BraintreeAdapter(new Braintree());

        System.out.println("Testing PayPal Adapter:");
        paypalProcessor.processPayment(100.00);

        System.out.println("\nTesting Braintree Adapter:");
        braintreeProcessor.processPayment(200.00);
    }
}
