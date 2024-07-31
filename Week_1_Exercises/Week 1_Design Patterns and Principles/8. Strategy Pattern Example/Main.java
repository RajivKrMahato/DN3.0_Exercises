// Main.java
public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("5678-1024-7548-6985", "Rajiv Kr Mahato");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.pay(32000.00);

        PaymentStrategy payPalPayment = new PayPalPayment("rajivmahto@paypal");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.pay(25000.00);
    }
}

