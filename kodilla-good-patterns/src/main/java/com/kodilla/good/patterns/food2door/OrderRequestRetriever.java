package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRequestRetriever {

    public List<OrderRequest> retriver() {

        List<OrderRequest> orderRequest = new ArrayList<>();
        User user = new User ("Andrzej");
        Map<Product, Integer> productsList = new HashMap<>();
        productsList.put(new HealthyShopProduct("Green tea", "BRA"), 10);
        LocalDateTime orderDate = LocalDateTime.now();

        User user1 = new User("Janusz");
        Map<Product, Integer> productsList1 = new HashMap<>();
        productsList1.put(new GlutenFreeShopProduct("Ground coffee Ethiopia"), 1);
        productsList1.put(new ExtraFoodShopProduct("Finnish xylitol"), 3);
        LocalDateTime orderDate1 = LocalDateTime.now();

        orderRequest.add(new OrderRequest(user, productsList, orderDate));
        orderRequest.add(new OrderRequest(user1, productsList1, orderDate1));

        return orderRequest;
    }
}
