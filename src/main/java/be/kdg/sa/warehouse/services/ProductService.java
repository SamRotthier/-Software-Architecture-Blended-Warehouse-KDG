package be.kdg.sa.warehouse.services;

import be.kdg.sa.warehouse.controller.dto.ProductDto;
import be.kdg.sa.warehouse.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import be.kdg.sa.warehouse.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


    public void addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setName(productDto.getProductName());
        product.setIngredientList(productDto.getIngredientList());

        productRepository.save(product);
        logger.info("A new product was saved in the db with name: {}", product.getName());
    }


}
