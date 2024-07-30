public class DecoratorPatternExample {

    // Component Interface
    public interface Notifier {
        void send(String message);
    }

    // Concrete Component
    public static class EmailNotifier implements Notifier {
        @Override
        public void send(String message) {
            System.out.println("Sending email notification: " + message);
        }
    }

    // Abstract Decorator
    public static abstract class NotifierDecorator implements Notifier {
        protected Notifier decoratedNotifier;

        public NotifierDecorator(Notifier decoratedNotifier) {
            this.decoratedNotifier = decoratedNotifier;
        }

        @Override
        public void send(String message) {
            decoratedNotifier.send(message);
        }
    }

    // Concrete Decorators
    public static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message); // Call the method of the decorated notifier
            System.out.println("Sending SMS notification: " + message);
        }
    }

    public static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message); // Call the method of the decorated notifier
            System.out.println("Sending Slack notification: " + message);
        }
    }

    // Test the Decorator Pattern
    public static void main(String[] args) {
        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello, this is a test message.");

        // Add SMS notification functionality
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Hello, this is a test message.");

        // Add Slack notification functionality
        Notifier slackNotifier = new SlackNotifierDecorator(new EmailNotifier());
        slackNotifier.send("Hello, this is a test message.");

        // Combine SMS and Slack notifications
        Notifier combinedNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        combinedNotifier.send("Hello, this is a test message.");
    }
}
