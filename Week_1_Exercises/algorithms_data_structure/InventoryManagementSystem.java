import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
   
   
    static class Product {
        private String productId;
        private String productName;
        private int quantity;
        private double price;
       
        public Product(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

      
        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
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
            return "Product ID: " + productId + ", Name: " + productName +
                   ", Quantity: " + quantity + ", Price: " + price;
        }
    }

    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }


    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

       public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

  
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    
    public void listProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
       
        
        ims.addProduct(new Product("001", "Laptop", 10, 999.99));
        ims.addProduct(new Product("002", "Smartphone", 25, 499.99));
       
      
        ims.listProducts();
       
       
        ims.updateProduct("001", new Product("001", "Laptop", 8, 949.99));
       
     
        ims.listProducts();
       
       
        ims.deleteProduct("002");
       
       
        ims.listProducts();
    }
}