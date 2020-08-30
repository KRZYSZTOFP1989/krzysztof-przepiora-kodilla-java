package com.kodilla.good.patterns.food2door;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        List<OrderRequest> retriver = new OrderRequestRetriever().retriver();
        orderService.processAllOrders(retriver);
        InfoServiceEmail infoServiceEmail = new InfoServiceEmail();
        infoServiceEmail.processAllOrdersDatabase(new OrderRequestRetriever().retriver());
    }
}

