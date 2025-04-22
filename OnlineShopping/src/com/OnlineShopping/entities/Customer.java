package com.OnlineShopping.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	
	private String address;
	private ShoppingCart shoppingcart;
	private List<Order> orders;
	
	public Customer(int userId, String username, String email, String address) {
        super(userId, username, email);
        this.address = address;
        this.shoppingcart = new ShoppingCart();
        this.orders = new ArrayList<>();
    }

    // Getters and setters
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public ShoppingCart getShoppingCart() { return shoppingcart; }
    public List<Order> getOrders() { return orders; }

    public void addOrder(Order order) {
        orders.add(order);
    }
    
}
