package be.kdg.sa.warehouse.receivers;

import be.kdg.sa.warehouse.config.RabbitTopology;
import be.kdg.sa.warehouse.controller.dto.IngredientDto;
import be.kdg.sa.warehouse.controller.dto.OrderDto;
import be.kdg.sa.warehouse.services.IngredientService;
import be.kdg.sa.warehouse.services.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {

    private final OrderService orderService;

    public OrderReceiver(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = RabbitTopology.ORDER_INGREDIENT_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void receiveOrderIngredients(OrderDto orderDto) {
        orderService.addOrder(orderDto);

    }

    @RabbitListener(queues = RabbitTopology.ORDER_INGREDIENT_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void receiveIngredient(IngredientDto ingredient) {
        //productService.addProduct(product.getId(), product.getName(), product.getDescription());
        System.out.println(ingredient);
    }
}
