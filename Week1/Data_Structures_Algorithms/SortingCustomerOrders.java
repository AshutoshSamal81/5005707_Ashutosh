public class SortingCustomerOrders {

    // Order class definition
    static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public int getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "OrderID: " + orderId + ", Customer: " + customerName + ", TotalPrice: " + totalPrice;
        }
    }

    // Bubble Sort implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Create an array of orders
        Order[] orders = {
            new Order(1, "Alice", 250.00),
            new Order(2, "Bob", 150.00),
            new Order(3, "Charlie", 300.00),
            new Order(4, "Diana", 200.00)
        };

        // Bubble Sort
        System.out.println("Bubble Sort:");
        Order[] ordersForBubbleSort = orders.clone();
        bubbleSort(ordersForBubbleSort);
        for (Order order : ordersForBubbleSort) {
            System.out.println(order);
        }

        // Quick Sort
        System.out.println("\nQuick Sort:");
        Order[] ordersForQuickSort = orders.clone();
        quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);
        for (Order order : ordersForQuickSort) {
            System.out.println(order);
        }
    }
}


/*
 Q1 Explain different sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort, Merge Sort).
 
 Bubble Sort
 Algorithm: Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order. 
 This process is repeated until the list is sorted.
 Time Complexity: Best Case: O(n) – The list is already sorted (with optimized version).
                  Average Case: O(n^2) – Average number of comparisons and swaps.
                  Worst Case: O(n^2) – The list is in reverse order.
 Space Complexity: O(1) – In-place sorting algorithm.

 Insertion Sort
 Algorithm: Insertion Sort builds the sorted list one item at a time by comparing the current item with the 
 already-sorted portion and inserting it in the correct position.
 Time Complexity: Best Case: O(n) – The list is already sorted.
                  Average Case: O(n^2) – Requires comparisons and shifts.
                  Worst Case: O(n^2) – The list is in reverse order.
 Space Complexity: O(1) – In-place sorting algorithm.

 Quick Sort
 Algorithm: Quick Sort uses a divide-and-conquer strategy. It selects a pivot element and partitions the array 
 into elements less than the pivot and elements greater than the pivot. It then recursively sorts the partitions.
 Time Complexity: Best Case: O(n log n) – Balanced partitions.
                  Average Case: O(n log n) – Typically balanced partitions.
                  Worst Case: O(n^2) – Poor partitioning (when the smallest or largest element is chosen as pivot).
 Space Complexity: O(log n) – Due to recursion stack.

 Merge Sort
 Algorithm: Merge Sort divides the array into halves, recursively sorts each half, and then merges the sorted halves.
 Time Complexity: O(n log n) – Both best and worst cases.
 Space Complexity: O(n) – Requires additional space for merging.



 */