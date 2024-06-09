package concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class InventoryManager {
    private ConcurrentHashMap<Integer, Product> products;

    public InventoryManager() {
        this.products = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
        System.out.println("Added: " + product);
    }

    public void removeProduct(int productId) {
        products.remove(productId);
        System.out.println("Removed product with ID: " + productId);
    }

    public void updateStock(int productId, int quantity) {
        Product product = products.get(productId);
        if (product != null) {
            product.setStock(product.getStock() + quantity);
            System.out.println("Updated stock for product ID " + productId + ": " + product.getStock());
        } else {
            System.out.println("Product not found for ID: " + productId);
        }
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }
}
