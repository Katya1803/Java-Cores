package SerializationAndFileIO;

import a.example.Example;

public class SerializationExample implements Example {
    @Override
    public void run() {
        CustomerManager manager = new CustomerManager();

        // Thêm một số khách hàng
        Customer customer1 = new Customer(1, "Alice", "alice@example.com", 1000.0);
        Customer customer2 = new Customer(2, "Bob", "bob@example.com", 2000.0);
        Customer customer3 = new Customer(3, "Charlie", "charlie@example.com", 3000.0);

        manager.addCustomer(customer1);
        manager.addCustomer(customer2);
        manager.addCustomer(customer3);

        System.out.println("\nList of customers:");
        manager.listCustomers();

        // Lưu danh sách khách hàng vào file
        String filename = "customers.ser";
        manager.saveToFile(filename);

        // Xóa danh sách khách hàng hiện tại
        manager = new CustomerManager();
        System.out.println("\nList of customers after clearing:");
        manager.listCustomers();

        // Tải danh sách khách hàng từ file
        manager.loadFromFile(filename);
        System.out.println("\nList of customers after loading from file:");
        manager.listCustomers();
    }
}
