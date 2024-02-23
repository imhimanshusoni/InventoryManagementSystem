import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {

    private static Map<String, Integer> inventory = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateStock();
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    System.out.println("Exiting Inventory Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== Inventory Management System =====");
        System.out.println("1. Add Product");
        System.out.println("2. Update Stock");
        System.out.println("3. Display Inventory");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter initial stock quantity: ");
        int initialStock = scanner.nextInt();

        inventory.put(productName, initialStock);
        System.out.printf("%s added to inventory with initial stock of %d.\n", productName, initialStock);
    }

    private static void updateStock() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        if (inventory.containsKey(productName)) {
            System.out.print("Enter new stock quantity: ");
            int newStock = scanner.nextInt();

            inventory.put(productName, newStock);
            System.out.printf("Stock for %s updated to %d.\n", productName, newStock);
        } else {
            System.out.println("Product not found in inventory. Please add the product first.");
        }
    }

    private static void displayInventory() {
        System.out.println("\n===== Current Inventory =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
