package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Provider {

    private Map<Product, Integer> productsList;

    public ExtraFoodShop() {
        createProductList();
    }

    private void createProductList() {

        Map<Product, Integer> productsList = new HashMap<>();
        productsList.put(new ExtraFoodShopProduct("Finnish xylitol"), 100);
        productsList.put(new ExtraFoodShopProduct("Almond cream"), 120);
        productsList.put(new ExtraFoodShopProduct("Ground coffee Ethiopia"), 110);
        productsList.put(new ExtraFoodShopProduct("Hazelnut cream with a hint of chocolate"), 40);
        productsList.put(new ExtraFoodShopProduct("Coconut cream"), 340);
        productsList.put(new ExtraFoodShopProduct("Green tea"), 500);
        productsList.put(new ExtraFoodShopProduct("Matcha tea"), 20);
    }

    @Override
    public boolean process(User user, Map<Product, Integer> productsOrders, LocalDateTime orderDate) {
        return true;
    }
}
