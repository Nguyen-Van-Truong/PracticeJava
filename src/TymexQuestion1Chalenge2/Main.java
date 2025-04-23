package TymexQuestion1Chalenge2;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();

        inventory.addProduct(new Product("Laptop", 999.99, 5));
        inventory.addProduct(new Product("Smartphone", 499.99, 10));
        inventory.addProduct(new Product("Tablet", 299.99, 0));
        inventory.addProduct(new Product("Smartwatch", 199.99, 3));

        // Tính tổng giá trị tồn kho
        double totalValue = inventory.calculateTotalInventoryValue();
        System.out.println("Total Inventory Value: " + totalValue);

        // Tìm sản phẩm có giá cao nhất
        String mostExpensive = inventory.findMostExpensiveProduct();
        System.out.println("Most Expensive Product: " + mostExpensive);

        // Kiểm tra xem sản phẩm "Headphones" có trong kho hay không
        boolean isHeadphonesInStock = inventory.isProductInStock("Headphones");
        System.out.println("Is 'Headphones' in stock: " + isHeadphonesInStock);

        // Sắp xếp sản phẩm theo giá giảm dần và hiển thị
        System.out.println("\nProducts sorted by price descending:");
        inventory.sortProducts("price", false);
        inventory.displayProducts();

        // Sắp xếp sản phẩm theo số lượng tăng dần và hiển thị
        System.out.println("\nProducts sorted by quantity ascending:");
        inventory.sortProducts("quantity", true);
        inventory.displayProducts();
    }
}
