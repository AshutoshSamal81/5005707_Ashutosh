import java.util.Arrays;

public class ECommerceSearch {

    // Define the Product class
    static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "ProductID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    // Linear Search Method
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }

    // Binary Search Method
    public static Product binarySearch(Product[] products, int productId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() < productId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        // Create an array of products
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Appliances"),
            new Product(4, "Desk Chair", "Furniture")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        // Test Linear Search
        System.out.println("Linear Search:");
        Product resultLinear = linearSearch(products, 3);
        if (resultLinear != null) {
            System.out.println("Found: " + resultLinear);
        } else {
            System.out.println("Product not found.");
        }

        // Test Binary Search
        System.out.println("\nBinary Search:");
        Product resultBinary = binarySearch(products, 3);
        if (resultBinary != null) {
            System.out.println("Found: " + resultBinary);
        } else {
            System.out.println("Product not found.");
        }
    }
}


/*
 Q1 Explain Big O notation and how it helps in analyzing algorithms.

 Big O notation is a mathematical notation used to describe the upper bound of the time complexity of an algorithm. 
 It provides an asymptotic analysis of how the runtime of an algorithm grows relative to the size of the input.
 O(1): Constant time – the algorithm’s runtime does not depend on the input size.
 O(n): Linear time – the runtime grows linearly with the input size.
 O(log n): Logarithmic time – the runtime grows logarithmically with the input size.
 O(n^2): Quadratic time – the runtime grows quadratically with the input size.

 
 Q2 Describe the best, average, and worst-case scenarios for search operations.

 Linear Search:
 Best Case: O(1) – The target element is found at the first position.
 Average Case: O(n) – On average, the target element is somewhere in the middle.
 Worst Case: O(n) – The target element is at the end or not present.
 
 Binary Search:
 Best Case: O(1) – The target element is found at the middle of the array.
 Average Case: O(log n) – The target element is found by repeatedly dividing the search space in half.
 Worst Case: O(log n) – The search space is reduced logarithmically until the target is found or the space is exhausted.

 */