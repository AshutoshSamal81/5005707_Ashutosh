public class SingletonPatternExample {

    // Singleton Logger class
    public static class Logger {
        
        // The single instance of Logger
        private static Logger instance;

        // Private constructor to prevent instantiation
        private Logger() {
            // Initialization code here (if needed)
        }

        // Public method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        // Example method for logging
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Main method to test the Singleton implementation
    public static void main(String[] args) {
        // Get two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }

        // Use the logger
        logger1.log("This is a test log message.");
    }
}
