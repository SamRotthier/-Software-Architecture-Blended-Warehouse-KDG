package be.kdg.sa.warehouse.receivers;

import be.kdg.sa.warehouse.config.RabbitTopology;
import be.kdg.sa.warehouse.controller.dto.ProductDto;
import be.kdg.sa.warehouse.services.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductReceiver {
    private final ProductService productService;

    public ProductReceiver(ProductService productService) {
        this.productService = productService;
    }

    @RabbitListener(queues = RabbitTopology.NEW_PRODUCT_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void receiveProduct(ProductDto productDto) {
        productService.addProduct(productDto);
    }
}
