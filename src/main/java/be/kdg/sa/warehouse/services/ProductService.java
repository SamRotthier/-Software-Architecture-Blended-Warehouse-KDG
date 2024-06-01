package be.kdg.sa.warehouse.services;

import be.kdg.sa.warehouse.controller.dto.ProductDto;
import be.kdg.sa.warehouse.controller.dto.ProductIngredientDto;
import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.domain.Product;
import be.kdg.sa.warehouse.domain.ProductIngredient;
import be.kdg.sa.warehouse.repositories.IngredientRepository;
import be.kdg.sa.warehouse.repositories.ProductIngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import be.kdg.sa.warehouse.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final ProductIngredientRepository productIngredientRepository;

    private final IngredientRepository ingredientRepository;

    public ProductService(ProductRepository productRepository, ProductIngredientRepository productIngredientRepository, IngredientRepository ingredientRepository) {
        this.productRepository = productRepository;
        this.productIngredientRepository = productIngredientRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public void addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setName(productDto.getName());
        Product savedProduct = productRepository.save(product);
        // productingredient list
        List<ProductIngredientDto> ingredients = productDto.getIngredients();

        if (ingredients != null) {
            for (ProductIngredientDto ingredientDto : ingredients) {
                Ingredient ingredient = ingredientRepository.findByName(ingredientDto.getName());
                if (ingredient == null) {
                    ingredient = new Ingredient();
                    ingredient.setName(ingredientDto.getName());
                    ingredientRepository.save(ingredient);
                }
            }
            logger.info("Saving product ingredients: {}", ingredients);
            productIngredientRepository.saveAll(ingredients.stream().filter(i -> i.getName() != null).map(i -> new ProductIngredient(savedProduct, ingredientRepository.findByName(i.getName()), i.getQuantity())).toList());
        }

        logger.info("A new product was saved in the db with name: {}", product.getName());
    }

}
