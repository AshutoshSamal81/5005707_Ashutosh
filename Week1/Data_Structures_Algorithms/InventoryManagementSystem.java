// InventoryManagementSystem.java

import java.util.HashMap;
import java.util.Map;

// Product Class
class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }
}

// Inventory Class
class Inventory {
    private Map<Integer, Product> productMap;

    public Inventory() {
        this.productMap = new HashMap<>();
    }

    // Add a product
    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    // Update a product
    public void updateProduct(int productId, String productName, int quantity, double price) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        productMap.remove(productId);
    }

    // Get a product
    public Product getProduct(int productId) {
        return productMap.get(productId);
    }

    // Display all products
    public void displayAllProducts() {
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }
}

// Test the Inventory Management System
public class InventoryManagementSystem {
    public static void main(String[] args) {
        // Create the inventory
        Inventory inventory = new Inventory();

        // Add products
        Product p1 = new Product(1, "Laptop", 10, 799.99);
        Product p2 = new Product(2, "Smartphone", 20, 499.99);
        inventory.addProduct(p1);
        inventory.addProduct(p2);

        // Display all products
        System.out.println("All Products:");
        inventory.displayAllProducts();

        // Update a product
        inventory.updateProduct(1, "Gaming Laptop", 5, 999.99);

        // Display the updated product
        System.out.println("\nUpdated Product:");
        System.out.println(inventory.getProduct(1));

        // Delete a product
        inventory.deleteProduct(2);

        // Display all products after deletion
        System.out.println("\nAll Products after Deletion:");
        inventory.displayAllProducts();
    }
}


/*

Q1 Why Data Structures and Algorithms are Essential
Efficient data structures and algorithms are critical in handling large inventories because:
  * Efficiency: They ensure quick access, insertion, and deletion of products.
  * Scalability: They support operations even as the inventory grows.
  * Data Integrity: They help maintain accurate and up-to-date inventory records.



Q2 Types of Data Structures Suitable for This Problem
ArrayList: Provides dynamic array functionality but is less efficient for operations involving searching and 
deleting by product ID, as it requires linear time complexity.
HashMap: Provides constant time complexity for key-based access, making it ideal for quick retrieval, 
insertion, and deletion of products. The key would be the product ID. 

*/