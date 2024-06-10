package SerializationAndFileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Added: " + customer);
    }

    public void removeCustomer(int customerId) {
        customers.removeIf(customer -> customer.getId() == customerId);
        System.out.println("Removed customer with ID: " + customerId);
    }

    public Customer getCustomer(int customerId) {
        return customers.stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst()
                .orElse(null);
    }

    public void listCustomers() {
        customers.forEach(System.out::println);
    }

    public void saveToFile(String filename) {
        File file = new File(filename);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(customers);
            System.out.println("Customer list saved to file: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving customer list to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        File file = new File(filename);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            customers = (List<Customer>) ois.readObject();
            System.out.println("Customer list loaded from file: " + file.getAbsolutePath());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading customer list from file: " + e.getMessage());
        }
    }
}
