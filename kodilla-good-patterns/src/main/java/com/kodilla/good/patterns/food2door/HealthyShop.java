package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements Provider {

    private Map<Product, Integer> productsList;

    public HealthyShop() {
        createProductList();
    }

    private void createProductList() {

        Map<Product, Integer> productsList = new HashMap<>();
        productsList.put(new HealthyShopProduct("Pasta", "IT"), 1000);
        productsList.put(new HealthyShopProduct("Almond cream", "DE"), 160);
        productsList.put(new HealthyShopProduct("Ground coffee Ethiopia", "ET"), 160);
        productsList.put(new HealthyShopProduct("Hazelnut cream with a hint of chocolate", "GR"), 20);
        productsList.put(new HealthyShopProduct("Coconut cream", "RU"), 540);
        productsList.put(new HealthyShopProduct("Green tea", "BRA"), 700);
        productsList.put(new HealthyShopProduct("Matcha tea", "IND"), 30);
    }

    @Override
    public boolean process(User user, Map<Product, Integer> productsOrders, LocalDateTime orderDate) {
        return true;
    }
}
