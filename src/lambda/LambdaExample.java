package lambda;

import a.example.Example;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample implements Example {
    @Override
    public void run() {
        // Khởi tạo danh sách sản phẩm
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 1200.00, "Electronics"));
        products.add(new Product(2, "Smartphone", 800.00, "Electronics"));
        products.add(new Product(3, "Coffee Maker", 100.00, "Home Appliances"));
        products.add(new Product(4, "Headphones", 150.00, "Electronics"));
        products.add(new Product(5, "Blender", 90.00, "Home Appliances"));

        System.out.println("Original list of products: ");
        products.forEach(System.out::println);

        // Lọc các sản phẩm theo danh mục "Electronics"
        List<Product> electronics = products.stream()
                .filter(p -> "Electronics".equals(p.getCategory()))
                .collect(Collectors.toList());

        System.out.println("\nFiltered Electronics products: ");
        electronics.forEach(System.out::println);

        // Tính tổng giá của các sản phẩm trong danh mục "Electronics"
        double totalElectronicsPrice = electronics.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("\nTotal price of Electronics products: " + totalElectronicsPrice);

        // Tăng giá của tất cả các sản phẩm lên 10%
        List<Product> increasedPriceProducts = products.stream()
                .map(p -> new Product(p.getId(), p.getName(), p.getPrice() * 1.10, p.getCategory()))
                .collect(Collectors.toList());

        System.out.println("\nProducts with increased prices: ");
        increasedPriceProducts.forEach(System.out::println);

        // Sắp xếp danh sách sản phẩm theo giá tăng dần
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());

        System.out.println("\nSorted products by price (ascending): ");
        sortedProducts.forEach(System.out::println);
    }
}
