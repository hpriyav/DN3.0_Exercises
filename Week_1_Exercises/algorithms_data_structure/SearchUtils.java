import java.util.Arrays;
import java.util.Comparator;

public class SearchUtils {
   
    
    public static Product linearSearch(Product[] products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductId().equals(searchTerm) ||
                product.getProductName().equalsIgnoreCase(searchTerm) ||
                product.getCategory().equalsIgnoreCase(searchTerm)) {
                return product;
            }
        }
        return null; 
    }
   

    public static Product binarySearch(Product[] products, String searchTerm) {
                Arrays.sort(products, Comparator.comparing(Product::getProductId));
       
        int left = 0;
        int right = products.length - 1;
       
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];
           
            if (midProduct.getProductId().equals(searchTerm)) {
                return midProduct;
            }
            if (midProduct.getProductId().compareTo(searchTerm) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;     }
   
    public static void main(String[] args) {
                Product[] products = {
            new Product("003", "Tablet", "Electronics"),
            new Product("001", "Laptop", "Electronics"),
            new Product("002", "Smartphone", "Electronics")
        };

               Product resultLinear = linearSearch(products, "Smartphone");
        if (resultLinear != null) {
            System.out.println("Linear Search Found: " + resultLinear);
        } else {
            System.out.println("Linear Search: Product not found.");
        }

                Product resultBinary = binarySearch(products, "001");
        if (resultBinary != null) {
            System.out.println("Binary Search Found: " + resultBinary);
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }
}

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}