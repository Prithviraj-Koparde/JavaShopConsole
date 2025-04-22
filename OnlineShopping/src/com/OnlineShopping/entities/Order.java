package com.OnlineShopping.entities;

import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<ProductQuantityPair> items;

    public Order(int orderId, Customer customer, List<ProductQuantityPair> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ProductQuantityPair> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + "\nCustomer: " + customer.getUsername() + "\nItems: " + items;
    }

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductQuantityPair[] getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}

	
}