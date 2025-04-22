// Program to define Order Service - place the order, update the status, retrieve order by ID, and list all orders
package com.OnlineShopping.services;

import java.util.ArrayList;
import java.util.List;

import com.OnlineShopping.entities.Order;
import com.OnlineShopping.entities.Product;
import com.OnlineShopping.entities.ProductQuantityPair;

public class OrderService {
    private List<Order> orderList = new ArrayList<>();

    // Constructor
    public OrderService() {
    }

    // Method to place an order
    public void placeOrder(Order order) {
        orderList.add(order);
        System.out.println("Order placed successfully!");
    }

    // Method to update the status of an order
    public void updateOrderStatus(int orderId, String status) {
        Order order = getOrder(orderId);

        if (order != null) {
            // Handle status updates and stock adjustments
            switch (status.toLowerCase()) {
                case "completed":
                    if ("Pending".equalsIgnoreCase(order.getStatus())) {
                        for (ProductQuantityPair pair : order.getProducts()) {
                            Product product = pair.getProduct();
                            int quantity = pair.getQuantity();

                            if (product.getStockQuantity() >= quantity) {
                                product.setStockQuantity(product.getStockQuantity() - quantity);
                            } else {
                                System.out.println("Insufficient stock for product: " + product.getName());
                                return;
                            }
                        }
                        order.setStatus("Completed");
                        System.out.println("Order status updated to Completed!");
                    } else {
                        System.out.println("Order is not in Pending state!");
                    }
                    break;
                case "cancelled":
                    if ("Completed".equalsIgnoreCase(order.getStatus()) || "Pending".equalsIgnoreCase(order.getStatus())) {
                        for (ProductQuantityPair pair : order.getProducts()) {
                            Product product = pair.getProduct();
                            int quantity = pair.getQuantity();
                            product.setStockQuantity(product.getStockQuantity() + quantity);
                        }
                        order.setStatus("Cancelled");
                        System.out.println("Order status updated to Cancelled!");
                    } else {
                        System.out.println("Cannot cancel an order that is not Pending or Completed!");
                    }
                    break;
                case "delivered":
                    if ("Completed".equalsIgnoreCase(order.getStatus())) {
                        order.setStatus("Delivered");
                        System.out.println("Order status updated to Delivered!");
                    } else {
                        System.out.println("Order must be Completed to update to Delivered!");
                    }
                    break;
                default:
                    System.out.println("Invalid status provided!");
            }
        } else {
            System.out.println("Order not found!");
        }
    }

    // Method to retrieve an order by ID
    public Order getOrder(int orderId) {
        return orderList.stream().filter(order -> order.getOrderId() == orderId).findFirst().orElse(null);
    }

    // Method to list all orders
    public List<Order> getOrders() {
        return orderList;
    }
}
