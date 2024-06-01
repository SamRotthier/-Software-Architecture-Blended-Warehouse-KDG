package be.kdg.sa.warehouse.receivers;

import be.kdg.sa.warehouse.config.RabbitTopology;
import be.kdg.sa.warehouse.controller.dto.ProductDto;
import be.kdg.sa.warehouse.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductReceiver {
    private static final Logger logger = LoggerFactory.getLogger(ProductReceiver.class);
    private final ProductService productService;

    public ProductReceiver(ProductService productService) {
        this.productService = productService;
    }

    @RabbitListener(queues = RabbitTopology.NEW_PRODUCT_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void receiveNewProduct(ProductDto productDto) {
        logger.info(String.valueOf(productDto));
        logger.info("Received a new product message with name: {}", productDto.getName());
        productService.addProduct(productDto);
    }
}
