package com.kodilla.patterns.challenges;

import java.time.LocalDate;

public class OrderServiceProduct implements OrderService {

    @Override
    public boolean order(User user, Product product, LocalDate date) {
        System.out.println("Order of" + " " + product + " " + "was created for:" + " " + user + " " + "on" + " " + date);
        return true;
    }
}
