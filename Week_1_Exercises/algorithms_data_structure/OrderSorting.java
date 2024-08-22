import java.util.*;

public class OrderSorting {

        static class Order {
        private String orderId;
        private String customerName;
        private double totalPrice;

        public Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: " + totalPrice;
        }
    }

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

  
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
              Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
              Order[] orders = {
            new Order("001", "Alice", 120.50),
            new Order("002", "Bob", 75.30),
            new Order("003", "Charlie", 200.00),
            new Order("004", "Diana", 150.75)
        };

        
        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        long bubbleStartTime = System.nanoTime();
        bubbleSort(bubbleSortedOrders);
        long bubbleEndTime = System.nanoTime();
        System.out.println("Bubble Sorted Orders:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }
        System.out.println("Bubble Sort Time: " + (bubbleEndTime - bubbleStartTime) + " ns");

       
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        long quickStartTime = System.nanoTime();
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        long quickEndTime = System.nanoTime();
        System.out.println("\nQuick Sorted Orders:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
        System.out.println("Quick Sort Time: " + (quickEndTime - quickStartTime) + " ns");
    }
}
