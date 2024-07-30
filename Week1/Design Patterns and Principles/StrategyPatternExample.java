// StrategyPatternExample.java

// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount +
                           " for card number: " + cardNumber + " and cardholder: " + name);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " for email: " + email);
    }
}

// Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Test the Strategy Pattern
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Create the context
        PaymentContext paymentContext = new PaymentContext();

        // Create and set Credit Card payment strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        paymentContext.setPaymentStrategy(creditCardPayment);
        System.out.println("Paying with Credit Card:");
        paymentContext.executePayment(150.75);

        // Create and set PayPal payment strategy
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        System.out.println("Paying with PayPal:");
        paymentContext.executePayment(200.50);
    }
}
