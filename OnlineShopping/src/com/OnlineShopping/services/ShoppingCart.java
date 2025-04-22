//Program to define ShoppingCart class
package com.OnlineShopping.services;

import java.util.HashMap;
import java.util.Map;

import com.OnlineShopping.entities.Product;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Getters and setters
    public Map<Product, Integer> getItems() {
        return items;
    }

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    @Override
    public String toString() {
        return "ShoppingCart [items=" + items + "]";
    }
}
