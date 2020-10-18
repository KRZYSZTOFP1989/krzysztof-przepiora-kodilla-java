package com.kodilla.patterns.challenges;

public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                           final OrderService orderService,
                           final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct(),
                orderRequest.getOrderDate());

        if(isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderDate());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(),true);
        } else
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(),false);
        }
}
