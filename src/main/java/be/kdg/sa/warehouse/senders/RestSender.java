package be.kdg.sa.warehouse.senders;

import be.kdg.sa.warehouse.config.RabbitTopology;
import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.domain.Order;
import be.kdg.sa.warehouse.services.IngredientService;
import be.kdg.sa.warehouse.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class RestSender {
    private static final Logger logger = LoggerFactory.getLogger(RestSender.class);
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    private final OrderService orderService;
    private final IngredientService ingredientService;

    public RestSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper,OrderService orderService, IngredientService ingredientService) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        this.orderService= orderService;
        this.ingredientService = ingredientService;
    }

    @PostMapping("/deliver/{uuid}")
    public void sendOrder(@PathVariable UUID uuid) {
        logger.debug("Trying to sendDelivery message for UUID: {}", uuid);
        Order order = orderService.getOrderById(uuid);
        Ingredient ingredient= ingredientService.getIngredientById(order.getIngredientid());

        if (ingredient.getingredientQuantity() >= order.getQuantity()){
            order.setOrderStatus(OrderStatus.SUCCESS);
        }else {
            order.setOrderStatus(OrderStatus.FAILED);
        }

        rabbitTemplate.convertAndSend(RabbitTopology.DELIVER_QUEUE, "DELIVER_QUEUE", (new OrderMessage(order)));

        logger.info("Delivery message was successfully posted to the DELIVER_QUEUE for UUID: {} with status: {}", order.getOrderId(), order.getOrderStatus());
    }
}
