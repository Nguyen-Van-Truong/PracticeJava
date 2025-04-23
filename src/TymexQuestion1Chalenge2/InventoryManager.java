package TymexQuestion1Chalenge2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InventoryManager {
    private List<Product> products;

    public InventoryManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalInventoryValue() {
        double totalValue = 0.0;
        for (Product product : products) {
            totalValue += product.getTotalValue();
        }
        return totalValue;
    }

    public String findMostExpensiveProduct() {
        Product maxPriceProduct = products.stream()
                .max(Comparator.comparing(Product::getPrice))
                .orElse(null);
        return maxPriceProduct != null ? maxPriceProduct.getName() : "No products available";
    }

    public boolean isProductInStock(String productName) {
        return products.stream().anyMatch(product -> product.getName().equalsIgnoreCase(productName));
    }

    public void sortProducts(String sortBy, boolean ascending) {
        if (sortBy.equalsIgnoreCase("price")) {
            products.sort(ascending ? Comparator.comparing(Product::getPrice)
                    : Comparator.comparing(Product::getPrice).reversed());
        } else if (sortBy.equalsIgnoreCase("quantity")) {
            products.sort(ascending ? Comparator.comparing(Product::getQuantity)
                    : Comparator.comparing(Product::getQuantity).reversed());
        }
    }

    // Hiển thị danh sách sản phẩm
    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product.getName() + ": Price " + product.getPrice() + ", Quantity " + product.getQuantity());
        }
    }
}
