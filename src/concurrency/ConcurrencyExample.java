package concurrency;

import a.example.Example;

public class ConcurrencyExample implements Example {
    @Override
    public void run() {
        InventoryManager inventoryManager = new InventoryManager();
        OrderProcessor orderProcessor = new OrderProcessor(inventoryManager);

        // Thêm một số sản phẩm vào kho
        Product product1 = new Product(1, "Laptop", 1200.00, 10);
        Product product2 = new Product(2, "Smartphone", 800.00, 20);
        Product product3 = new Product(3, "Coffee Maker", 100.00, 15);

        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2);
        inventoryManager.addProduct(product3);

        // Đặt một số đơn hàng
        Thread orderThread = new Thread(() -> {
            orderProcessor.placeOrder(new Order(1, 1, 2));
            orderProcessor.placeOrder(new Order(2, 2, 1));
            orderProcessor.placeOrder(new Order(3, 3, 3));
            orderProcessor.placeOrder(new Order(4, 1, 5));
        });

        // Xử lý các đơn hàng
        Thread processingThread = new Thread(orderProcessor::processOrders);

        orderThread.start();
        processingThread.start();

        try {
            orderThread.join();
            processingThread.interrupt(); // Dừng việc xử lý đơn hàng sau khi đã đặt hết
            processingThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
