package be.kdg.sa.warehouse.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopology {

    public final static String DELIVER_QUEUE = "deliver-queue";
    public final static String ORDER_INGREDIENT_QUEUE = "order-ingredient-queue";
    public final static String NEW_PRODUCT_QUEUE = "new-product-queue";
    public static final String TOPIC_EXCHANGE = "bakery-exchange";


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    //this is a new deliver queue
    @Bean
    public Queue newOrderIngredientQueue() {
        return new Queue(ORDER_INGREDIENT_QUEUE, false);
    }

    @Bean
    public Binding topicNewOrderIngredientBinding() {
        return BindingBuilder.bind(newOrderIngredientQueue()).to(topicExchange()).with(ORDER_INGREDIENT_QUEUE);
    }

    @Bean
    public Queue newProductQueue() {
        return new Queue(NEW_PRODUCT_QUEUE, false);
    }

    @Bean
    public Binding topicNewProductBinding() {
        return BindingBuilder.bind(newProductQueue()).to(topicExchange()).with(NEW_PRODUCT_QUEUE);
    }

    @Bean
    public Queue newDeliverQueue() {
        return new Queue(DELIVER_QUEUE, false);
    }

    @Bean
    public Binding topicNewDeliverBinding() {
        return BindingBuilder.bind(newDeliverQueue()).to(topicExchange()).with(DELIVER_QUEUE);
    }


    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
