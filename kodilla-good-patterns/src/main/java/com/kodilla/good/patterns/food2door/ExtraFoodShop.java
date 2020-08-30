package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.Map;

public class ExtraFoodShop implements Provider {
    @Override
    public boolean process(User user, Map<Product, Integer> productsOrders, LocalDateTime orderDate) {
        return true;
    }
}
