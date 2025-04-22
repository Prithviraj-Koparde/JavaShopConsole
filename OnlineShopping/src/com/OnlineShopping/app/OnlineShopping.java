// Program to demonstrate Online Shopping Application
package com.OnlineShopping.app;

import java.util.Scanner;
import com.OnlineShopping.entities.Product;
import com.OnlineShopping.entities.Admin;
import com.OnlineShopping.services.AdminService;
import com.OnlineShopping.services.OrderService;
import com.OnlineShopping.services.ProductService;

public class OnlineShopping {

    private static ProductService productService = new ProductService();
    private static OrderService orderService = new OrderService();
    private static AdminService adminService = new AdminService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            // Validate user input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number!");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    customerMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting application...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner) {
        int adminChoice = 0;
        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Return");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number!");
                scanner.next();
                continue;
            }

            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    removeProduct(scanner);
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    createAdmin(scanner);
                    break;
                case 5:
                    viewAdmins();
                    break;
                case 6:
                    updateOrderStatus(scanner);
                    break;
                case 7:
                    viewOrders();
                    break;
                case 8:
                    System.out.println("Exiting Admin...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (adminChoice != 8);
    }

    private static void customerMenu(Scanner scanner) {
        System.out.println("Customer Menu is under development.");
        // You can implement actions such as placing orders or browsing products here.
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Stock Quantity: ");
        int stockQuantity = scanner.nextInt();

        if (productId <= 0 || price <= 0 || stockQuantity < 0) {
            System.out.println("Invalid input. Product details must be positive!");
            return;
        }

        Product product = new Product(productId, name, price, stockQuantity);
        productService.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter Product ID to remove: ");
        int productId = scanner.nextInt();
        
        if (productId <= 0) {
            System.out.println("Invalid Product ID!");
            return;
        }

        productService.removeProduct(productId);
        System.out.println("Product removed successfully!");
    }

    private static void viewProducts() {
        System.out.println("Products:");
        productService.getProducts().forEach(System.out::println);
    }

    private static void createAdmin(Scanner scanner) {
        System.out.print("Enter Admin ID: ");
        int adminId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Admin Name: ");
        String adminName = scanner.nextLine();
        System.out.print("Enter Admin Email: ");
        String adminEmail = scanner.nextLine();

        if (adminId <= 0 || adminName.isEmpty() || adminEmail.isEmpty()) {
            System.out.println("Invalid input. All fields are required!");
            return;
        }

        Admin admin = new Admin(adminId, adminName, adminEmail);
        adminService.addAdmin(admin);
        System.out.println("Admin created successfully!");
    }

    private static void viewAdmins() {
        System.out.println("Admins:");
        adminService.getAdmins().forEach(System.out::println);
    }

    private static void updateOrderStatus(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
        String status = scanner.nextLine();

        if (!status.equalsIgnoreCase("Completed") &&
            !status.equalsIgnoreCase("Delivered") &&
            !status.equalsIgnoreCase("Cancelled")) {
            System.out.println("Invalid status! Please try again.");
            return;
        }

        orderService.updateOrderStatus(orderId, status);
        System.out.println("Order status updated successfully!");
    }

    private static void viewOrders() {
        System.out.println("Orders:");
        orderService.getOrders().forEach(System.out::println);
    }
}
