package be.kdg.sa.warehouse.services;

import be.kdg.sa.warehouse.controller.dto.OrderDto;
import be.kdg.sa.warehouse.controller.dto.OrderIngredientsDto;
import be.kdg.sa.warehouse.controller.dto.ProductDto;
import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import be.kdg.sa.warehouse.domain.Order;
import be.kdg.sa.warehouse.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kdg.sa.warehouse.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }


    public void addOrder(OrderIngredientsDto orderIngredientsDto) {

        Order order = new Order();
        order.setOrderId(orderIngredientsDto.getId());
        order.setOrderTimestamp(orderIngredientsDto.getBakeStartTimestamp());

       // order.setIngredients(orderIngredientsDto.getIngredients());


        order.setOrderStatus(OrderStatus.UNSEND);

        orderRepository.save(order);
        logger.info("A new order was saved in the db with id: {}", order.getOrderId());
    }

    public Order getOrderById(UUID uuid) {
       return orderRepository.getOrderByOrderId(uuid);
    }




}
