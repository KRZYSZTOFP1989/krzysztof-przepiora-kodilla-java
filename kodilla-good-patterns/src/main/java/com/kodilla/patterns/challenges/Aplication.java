package com.kodilla.patterns.challenges;

public class Aplication {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retriver();

        ProductOrderService productOrderService = new ProductOrderService(
               new InformationServiceEmail(), new OrderServiceProduct(), new OrderRepositoryDatabase());
        productOrderService.process(orderRequest);

    }
}
