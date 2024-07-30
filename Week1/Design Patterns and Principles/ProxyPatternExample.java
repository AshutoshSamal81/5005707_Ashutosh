public class ProxyPatternExample {

    // Subject Interface
    public interface Image {
        void display();
    }

    // Real Subject Class
    public static class RealImage implements Image {
        private final String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading image: " + filename);
            // Simulate loading image from a remote server
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // Proxy Class
    public static class ProxyImage implements Image {
        private RealImage realImage;
        private final String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

    // Test the Proxy Pattern
    public static void main(String[] args) {
        // Create a proxy image
        Image image1 = new ProxyImage("image1.jpg");
        
        // Image is loaded and displayed only when requested
        System.out.println("First display request:");
        image1.display();
        
        // Image is cached, so no loading from server on subsequent requests
        System.out.println("Second display request:");
        image1.display();

        // Create another proxy image
        Image image2 = new ProxyImage("image2.jpg");
        
        // Image is loaded and displayed only when requested
        System.out.println("Displaying another image:");
        image2.display();
    }
}
