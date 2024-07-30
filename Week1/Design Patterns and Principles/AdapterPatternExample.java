public class AdapterPatternExample {

    // Target Interface
    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Adaptee Classes (Third-party payment gateways)
    public static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " via PayPal.");
        }
    }

    public static class StripeGateway {
        public void charge(double amount) {
            System.out.println("Charging $" + amount + " through Stripe.");
        }
    }

    public static class SquareGateway {
        public void executePayment(double amount) {
            System.out.println("Executing payment of $" + amount + " with Square.");
        }
    }

    // Adapter Classes
    public static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway payPalGateway;

        public PayPalAdapter(PayPalGateway payPalGateway) {
            this.payPalGateway = payPalGateway;
        }

        @Override
        public void processPayment(double amount) {
            payPalGateway.makePayment(amount);
        }
    }

    public static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripeGateway;

        public StripeAdapter(StripeGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }

        @Override
        public void processPayment(double amount) {
            stripeGateway.charge(amount);
        }
    }

    public static class SquareAdapter implements PaymentProcessor {
        private SquareGateway squareGateway;

        public SquareAdapter(SquareGateway squareGateway) {
            this.squareGateway = squareGateway;
        }

        @Override
        public void processPayment(double amount) {
            squareGateway.executePayment(amount);
        }
    }

    // Test the Adapter Pattern
    public static void main(String[] args) {
        // Create instances of third-party payment gateways
        PayPalGateway payPal = new PayPalGateway();
        StripeGateway stripe = new StripeGateway();
        SquareGateway square = new SquareGateway();

        // Create adapters for each gateway
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        PaymentProcessor squareAdapter = new SquareAdapter(square);

        // Process payments through adapters
        payPalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(200.0);
        squareAdapter.processPayment(300.0);
    }
}

