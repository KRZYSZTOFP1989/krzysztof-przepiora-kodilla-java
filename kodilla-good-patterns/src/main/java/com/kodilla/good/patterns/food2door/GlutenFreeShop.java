package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlutenFreeShop implements Provider {

    private Map<Product, Integer> productsList;
    private List<Product> blockadeList;

    public GlutenFreeShop() {
        productsList = createProductList();
        blockadeList = createBlockadeList();
    }

    private Map<Product, Integer> createProductList() {

        Map<Product, Integer> productsList = new HashMap<>();
        productsList.put(new GlutenFreeShopProduct("Rice"), 100);
        productsList.put(new GlutenFreeShopProduct("Almond cream"), 160);
        productsList.put(new GlutenFreeShopProduct("Ground coffee Ethiopia"), 160);
        productsList.put(new GlutenFreeShopProduct("Hazelnut cream with a hint of chocolate"), 20);
        productsList.put(new GlutenFreeShopProduct("Coconut cream"), 540);
        productsList.put(new GlutenFreeShopProduct("Green tea"), 700);
        productsList.put(new GlutenFreeShopProduct("Matcha tea"), 30);

        return productsList;
    }

    private List<Product> createBlockadeList() {

        List<Product> blockadeList = new ArrayList<>();
        blockadeList.add(new GlutenFreeShopProduct("Pasta"));

        return blockadeList;
    }

    @Override
    public boolean process(User user, Map<Product, Integer> productsOrders, LocalDateTime orderDate) {
        return true;
    }
}
