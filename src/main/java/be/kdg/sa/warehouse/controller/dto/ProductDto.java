package be.kdg.sa.warehouse.controller.dto;


import be.kdg.sa.warehouse.domain.ProductIngredient;

import java.util.List;
import java.util.UUID;

public class ProductDto {

    private UUID productId;
    private String name;
    private List<ProductIngredientDto> ingredients;

    public ProductDto() {

    }

    public ProductDto(String productName, List<ProductIngredientDto> ingredients) {
        this.name = productName;
        this.ingredients = ingredients;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }
    public List<ProductIngredientDto> getIngredients() {
        return ingredients;
    }


    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<ProductIngredientDto> ingredients) {
        this.ingredients = ingredients;
    }
}
