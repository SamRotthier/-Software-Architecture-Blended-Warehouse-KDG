package be.kdg.sa.warehouse.controller.dto;


import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.domain.ProductIngredient;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

public class ProductDto {

    private UUID ingredientId;
    private String productName;

    private List<ProductIngredient> ingredientList;


    public ProductDto() {

    }

    public ProductDto(String productName, List<ProductIngredient> ingredientList) {
        this.productName = productName;
        this.ingredientList = ingredientList;
    }

    public UUID getIngredientId() {
        return ingredientId;
    }

    public String getProductName() {
        return productName;
    }

    public List<ProductIngredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientId(UUID ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setIngredientList(List<ProductIngredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
