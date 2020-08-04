package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRepositoryDatabase implements OrderRepository {

    @Override
    public boolean createOrder(User user, Product product, LocalDate date) {
        System.out.println(user + " " + "order for" + " " + product + " " + "was saved on" + " " + date.toString());
        return true;
    }

}
