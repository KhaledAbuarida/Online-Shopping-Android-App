package com.example.e_commerce.Model;

import java.util.ArrayList;

public class OrderDetails {
    private int order_id;
    private ArrayList<Product> products;


    public OrderDetails(int order_id) {
        this.order_id = order_id;
        this.products = new ArrayList<>();
    }

    public int getOrder_id() {
        return order_id;
    }

    // Method to get a list of product names
    public ArrayList<String> getProductNames() {
        ArrayList<String> productNames = new ArrayList<>();
        for (Product product : products) {
            productNames.add(product.getName());
        }
        return productNames;
    }

    public ArrayList<Integer> getProductQuantities() {
        ArrayList<Integer> productQuantities = new ArrayList<>();
        for (Product product : products) {
            productQuantities.add(product.getQuantity());
        }
        return productQuantities;
    }
    public ArrayList<Double> getProductPrices() {
        ArrayList<Double> productPrices = new ArrayList<>();
        for (Product product : products) {
            productPrices.add(product.getPrice());
        }
        return productPrices;
    }
}
