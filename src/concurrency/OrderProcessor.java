package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderProcessor {
    private BlockingQueue<Order> orderQueue;
    private InventoryManager inventoryManager;

    public OrderProcessor(InventoryManager inventoryManager) {
        this.orderQueue = new LinkedBlockingQueue<>();
        this.inventoryManager = inventoryManager;
    }

    public void placeOrder(Order order) {
        try {
            orderQueue.put(order);
            System.out.println("Placed order: " + order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void processOrders() {
        while (true) {
            try {
                Order order = orderQueue.take();
                Product product = inventoryManager.getProduct(order.getProductId());
                if (product != null && product.getStock() >= order.getQuantity()) {
                    inventoryManager.updateStock(order.getProductId(), -order.getQuantity());
                    System.out.println("Processed order: " + order);
                } else {
                    System.out.println("Order could not be processed (insufficient stock or product not found): " + order);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
