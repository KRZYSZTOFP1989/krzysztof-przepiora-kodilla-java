package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRequestRetriever {

    public List<OrderRequest> retriver() {

        List<OrderRequest> orderRequest = new ArrayList<>();

        User user = new User("Andrzej");
        Provider provider = new HealthyShop();
        Map<Product, Integer> productsList = new HashMap<>();
        productsList.put(new HealthyShopProduct("Almond cream", "PL"), 2);
        LocalDateTime orderDate = LocalDateTime.now();

        User user1 = new User("Janusz");
        Provider provider1 = new GlutenFreeShop();
        Provider provider2 = new ExtraFoodShop();
        Map<Product, Integer> productsList1 = new HashMap<>();
        productsList1.put(new GlutenFreeShopProduct("Hazelnut cream with a hint of chocolate"), 3);
        productsList1.put(new ExtraFoodShopProduct("Finnish xylitol"), 3);
        LocalDateTime orderDate1 = LocalDateTime.now();

        orderRequest.add(new OrderRequest(user, provider, productsList, orderDate));
        orderRequest.add(new OrderRequest(user1, provider1, productsList1, orderDate1));
        orderRequest.add(new OrderRequest(user1, provider2, productsList1, orderDate1));

        return orderRequest;
    }

}
