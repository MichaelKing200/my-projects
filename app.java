import java.io.*;
import java.util.*;

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Sales {
    String productName;
    int quantitySold;
    double totalAmount;

    public Sales(String productName, int quantitySold, double totalAmount) {
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.totalAmount = totalAmount;
    }
}

public class SalesInventorySystem {
    private static Map<String, Product> inventory = new HashMap<>();
    private static List<Sales> salesHistory = new ArrayList<>();

    public static void main(String[] args) {
        initializeInventory();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Make a Sale");
            System.out.println("2. Generate Report");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makeSale();
                    break;
                case 2:
                    generateReport();
                    break;
                case 3:
                    saveInventoryToFile();
                    saveSalesHistoryToFile();
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeInventory() {
        // Load initial inventory from a file or set default values
        // For simplicity, let's set some initial products
        inventory.put("Product1", new Product("Product1", 10.0, 100));
        inventory.put("Product2", new Product("Product2", 20.0, 50));
    }

    private static void makeSale() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();

        if (inventory.containsKey(productName)) {
            Product product = inventory.get(productName);

            System.out.println("Enter quantity to sell: ");
            int quantitySold = scanner.nextInt();

            if (quantitySold > 0 && quantitySold <= product.quantity) {
                double totalAmount = quantitySold * product.price;

                // Update inventory
                product.quantity -= quantitySold;

                // Update sales history
                salesHistory.add(new Sales(productName, quantitySold, totalAmount));

                System.out.println("Sale successful. Total amount: $" + totalAmount);
            } else {
                System.out.println("Invalid quantity. Sale unsuccessful.");
            }
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    private static void generateReport() {
        double totalSales = 0;

        System.out.println("\nSales Report:");
        System.out.println("Product\tQuantity\tTotal Amount");

        for (Sales sale : salesHistory) {
            System.out.println(sale.productName + "\t" + sale.quantitySold + "\t\t$" + sale.totalAmount);
            totalSales += sale.totalAmount;
        }

        System.out.println("\nTotal Sales: $" + totalSales);
    }

    private static void saveInventoryToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("inventory.ser"))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveSalesHistoryToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("salesHistory.ser"))) {
            oos.writeObject(salesHistory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
