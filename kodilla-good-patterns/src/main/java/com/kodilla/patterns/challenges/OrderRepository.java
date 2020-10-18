package com.kodilla.patterns.challenges;

import java.time.LocalDate;

public interface OrderRepository {
    boolean createOrder(User user, Product product, LocalDate orderTime);
}
