package be.kdg.sa.warehouse.Senders;

import be.kdg.sa.warehouse.config.RabbitTopology;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RestSender {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public RestSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/send/{uuid}")
    public void sendOrder(@PathVariable UUID uuid) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(RabbitTopology.DELIVER_QUEUE, "DELIVER_QUEUE", objectMapper.writeValueAsString(new OrderMessage(uuid)));
    }

}
