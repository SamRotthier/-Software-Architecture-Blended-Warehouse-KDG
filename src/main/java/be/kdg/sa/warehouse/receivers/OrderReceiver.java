package be.kdg.sa.warehouse.receivers;

import be.kdg.sa.warehouse.controller.dto.OrderIngredientsDto;
import be.kdg.sa.warehouse.receivers.messages.ConfirmationMessage;
import be.kdg.sa.warehouse.senders.RestSender;
import be.kdg.sa.warehouse.config.RabbitTopology;
import be.kdg.sa.warehouse.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {
    private static final Logger logger = LoggerFactory.getLogger(OrderReceiver.class);
    private final OrderService orderService;
    private final RestSender restSender;

    public OrderReceiver(OrderService orderService, RestSender restSender) {
        this.orderService = orderService;
        this.restSender=restSender;
    }

    @RabbitListener(queues = RabbitTopology.ORDER_INGREDIENT_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void receiveOrderIngredients(OrderIngredientsDto orderIngredientsDto){
        logger.info("Received an order message with UUID: {}", orderIngredientsDto.getId());
        logger.info("UUID: {}/ ingredientsmap (first):{}/ timestamp{}", orderIngredientsDto.getId(),orderIngredientsDto.getIngredients().keySet().stream().findFirst(),orderIngredientsDto.getBakeStartTimestamp());

        orderService.addOrder(orderIngredientsDto);

        restSender.sendOrder(orderIngredientsDto.getId());
    }

    @RabbitListener(queues = RabbitTopology.CONFIRM_ORDER_INGREDIENT_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void receiveConfirmOrder(ConfirmationMessage message){
        logger.info("Received a confirmation:{}", message.getMessage());
    }
}
