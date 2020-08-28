package com.kodilla.good.patterns.food2door;

public class Aplication {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        InfoServiceEmail infoServiceEmail = new InfoServiceEmail();
        orderService.processAllOrders(new OrderRequestRetriever().retriver());
        infoServiceEmail.processAllOrdersDatabase(new OrderRequestRetriever().retriver());

    }
}

