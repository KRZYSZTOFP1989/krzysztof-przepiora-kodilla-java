package com.kodilla.good.patterns.food2door;

import java.util.List;

public class OrderService {

    public void processAllOrders(List<OrderRequest> orderRequest) {

        orderRequest.stream()
                .map(n -> {
                    System.out.println("Order for: " + n.getUser().getName());
                    return n.getProvider().process(n.getUser(), n.getProductsOrderRequest(), n.getOrderDate());
                })
                .forEach(t -> System.out.println("Order finished with success: " + t + "\n"));
    }
}
