package be.kdg.sa.warehouse.services;

import be.kdg.sa.warehouse.controller.dto.OrderDto;
import be.kdg.sa.warehouse.controller.dto.OrderIngredientsDto;
import be.kdg.sa.warehouse.controller.dto.ProductDto;
import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.domain.Order;
import be.kdg.sa.warehouse.domain.OrderIngredient;
import be.kdg.sa.warehouse.domain.Product;
import be.kdg.sa.warehouse.repositories.IngredientRepository;
import be.kdg.sa.warehouse.repositories.OrderIngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kdg.sa.warehouse.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;
    private final IngredientRepository ingredientRepository;

    private final OrderIngredientRepository orderIngredientRepository;

    public OrderService(OrderRepository orderRepository,IngredientRepository ingredientRepository,OrderIngredientRepository OrderIngredientRepository){
        this.orderRepository=orderRepository;
        this.ingredientRepository=ingredientRepository;
        this.orderIngredientRepository=OrderIngredientRepository;
    }

    public void addOrder(OrderIngredientsDto orderIngredientsDto) {

        Order order = new Order();
        order.setOrderId(orderIngredientsDto.getId());
        order.setOrderTimestamp(orderIngredientsDto.getBakeStartTimestamp());
        order.setOrderStatus(OrderStatus.UNSEND);
        orderRepository.save(order);
        logger.info("A new order was saved in the db with id: {}", order.getOrderId());

        //List<OrderIngredient> orderIngredients = new ArrayList<>();

        logger.info("Ingredients linked to order are saved to the db.");
        for (Map.Entry<UUID, Integer> entry : orderIngredientsDto.getIngredients().entrySet()) {
            logger.info("Ingredient ID: {}", entry.getKey());
            Ingredient ingredient = ingredientRepository.findById(entry.getKey()).orElseThrow();
            OrderIngredient orderIngredient = new OrderIngredient();
            orderIngredient.setOrder(order);
            orderIngredient.setIngredient(ingredient);
            orderIngredient.setQuantity(entry.getValue());
            orderIngredientRepository.save(orderIngredient);
            //orderIngredients.add(orderIngredient);
        }
    }

    public Order getOrderById(UUID uuid) {
       return orderRepository.getOrderByOrderId(uuid);
    }
}
