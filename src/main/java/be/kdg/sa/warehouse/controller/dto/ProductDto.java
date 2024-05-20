package be.kdg.sa.warehouse.controller.dto;


import be.kdg.sa.warehouse.domain.ProductIngredient;

import java.util.List;
import java.util.UUID;

public class ProductDto {

    private UUID productId;
    private String productName;

    private List<ProductIngredient> ingredientList;


    public ProductDto() {

    }

    public ProductDto(String productName, List<ProductIngredient> ingredientList) {
        this.productName = productName;
        this.ingredientList = ingredientList;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public List<ProductIngredient> getIngredientList() {
        return ingredientList;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setIngredientList(List<ProductIngredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
