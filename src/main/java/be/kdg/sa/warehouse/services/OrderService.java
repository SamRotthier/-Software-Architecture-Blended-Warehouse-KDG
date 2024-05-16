package be.kdg.sa.warehouse.services;

import be.kdg.sa.warehouse.controller.dto.OrderDto;
import be.kdg.sa.warehouse.controller.dto.ProductDto;
import be.kdg.sa.warehouse.domain.Order;
import be.kdg.sa.warehouse.domain.Product;
import be.kdg.sa.warehouse.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }


    public void addOrder(OrderDto orderDto) {

        Order order = new Order();
        order.setOrderId(orderDto.getOrderId());
        order.setOrderTimestamp(orderDto.getOrderTimestamp());
        order.setIngredientid(orderDto.getIngredientid());
        order.setQuantity(orderDto.getQuantity());

        orderRepository.save(order);
    }



}
