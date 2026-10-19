import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int command = readInt("Enter command (1-5): ");
            try {
                switch (command) {
                    case 1: addPerishable(); break;
                    case 2: addNonPerishable(); break;
                    case 3: displayProducts(); break;
                    case 4: restockProduct(); break;
                    case 5:
                        System.out.println("Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Error: choose a number from 1 to 5.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("Supermarket Inventory System");
        System.out.println("1. Add Perishable Product");
        System.out.println("2. Add Non-Perishable Product");
        System.out.println("3. Display Product Info");
        System.out.println("4. Restock Product");
        System.out.println("5. Exit");
    }

    private static void addPerishable() {
        String id = readText("Enter Product ID: ");
        String name = readText("Enter Product Name: ");
        double price = readDouble("Enter Price: ");
        int quantity = readInt("Enter Quantity: ");
        String expiry = readText("Enter Expiry Date (YYYY-MM-DD): ");
        products.add(new PerishableProduct(id, name, price, quantity, expiry));
    }

    private static void addNonPerishable() {
        String id = readText("Enter Product ID: ");
        String name = readText("Enter Product Name: ");
        double price = readDouble("Enter Price: ");
        int quantity = readInt("Enter Quantity: ");
        String warranty = readText("Enter Warranty Period: ");
        products.add(new NonPerishableProduct(id, name, price, quantity, warranty));
    }

    private static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products yet.");
            return;
        }
        for (Product p : products) {
            System.out.println(p.getProductInfo());
        }
    }

    private static void restockProduct() {
        if (products.isEmpty()) {
            System.out.println("No products yet.");
            return;
        }
        String id = readText("Enter Product ID: ");
        for (Product p : products) {
            if (p.getProductId().equalsIgnoreCase(id)) {
                p.restock(readInt("Enter Restock Amount: "));
                return;
            }
        }
        System.out.println("Error: product with ID '" + id + "' not found.");
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int readInt(String prompt) {
        while (true) {
            String line = readText(prompt).trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + line + "' is not a valid whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            String line = readText(prompt).trim().replace(',', '.');
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + line + "' is not a valid number.");
            }
        }
    }
}