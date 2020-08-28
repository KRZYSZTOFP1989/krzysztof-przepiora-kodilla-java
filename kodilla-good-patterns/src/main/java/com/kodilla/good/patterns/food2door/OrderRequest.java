package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.Map;

public class OrderRequest implements Provider{

    private User user;
    private Map<Product, Integer> productsOrderRequest;
    private LocalDateTime orderDate;

    public OrderRequest(User user, Map<Product, Integer> productsOrderRequest, LocalDateTime orderDate) {
        this.user = user;
        this.productsOrderRequest = productsOrderRequest;
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Integer> getProductsOrderRequest() {
        return productsOrderRequest;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    @Override
    public boolean process(User user, Map<Product, Integer> productsOrders, LocalDateTime orderDate) {
        return true;
    }
}
