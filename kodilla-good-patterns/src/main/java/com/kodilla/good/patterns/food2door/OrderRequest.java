package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.Map;

public class OrderRequest {

    private User user;
    private Provider provider;
    private Map<Product, Integer> productsOrderRequest;
    private LocalDateTime orderDate;

    public OrderRequest(User user, Provider provider, Map<Product, Integer> productsOrderRequest, LocalDateTime orderDate) {
        this.user = user;
        this.provider = provider;
        this.productsOrderRequest = productsOrderRequest;
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public Provider getProvider() {
        return provider;
    }

    public Map<Product, Integer> getProductsOrderRequest() {
        return productsOrderRequest;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

}
