package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.Map;

public interface Provider {

    boolean process(User user, Map<Product, Integer> productsOrders, LocalDateTime orderDate);

}
