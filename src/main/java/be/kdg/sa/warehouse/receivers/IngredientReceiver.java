package be.kdg.sa.warehouse.receivers;

import be.kdg.sa.warehouse.config.RabbitTopology;
import be.kdg.sa.warehouse.controller.dto.IngredientDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class IngredientReceiver {

    private final IngredientReceiver ingredientReceiver;

    public IngredientReceiver(IngredientReceiver ingredientReceiver) {
        this.ingredientReceiver = ingredientReceiver;
    }

    @RabbitListener(queues = RabbitTopology.DELIVER, messageConverter = "#{jackson2JsonMessageConverter}")
    public void receiveIngredient(IngredientDto ingredient) {
        //productService.addProduct(product.getId(), product.getName(), product.getDescription());
        System.out.println(ingredient);
    }
}
