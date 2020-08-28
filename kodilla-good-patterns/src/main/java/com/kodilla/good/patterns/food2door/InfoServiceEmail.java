package com.kodilla.good.patterns.food2door;

import java.util.List;

public class InfoServiceEmail {

    public void processAllOrdersDatabase(List<OrderRequest> orderRequest) {

        orderRequest.stream()
                .map(n -> {
                    System.out.println("Hello " + n.getUser().getName() + " your order for" + " " + n.getProductsOrderRequest()
                     + " was saved on " + n.getOrderDate());
                    return n.process(n.getUser(), n.getProductsOrderRequest(), n.getOrderDate());
                })
                .forEach(t -> System.out.println("Order finished with success: " + t + "\n"));
    }

}
