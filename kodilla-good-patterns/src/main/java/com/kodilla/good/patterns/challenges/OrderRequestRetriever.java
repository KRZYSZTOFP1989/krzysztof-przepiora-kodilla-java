package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRequestRetriever {

    public OrderRequest retriver() {
        User user = new User("Andrew");
        Product product = new Product("Adidas shoes", 399.99);
        LocalDate date = LocalDate.now();

        return new OrderRequest(user, product, date);
    }
}
