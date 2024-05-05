package be.kdg.sa.warehouse.controller.dto;

import java.util.UUID;

public class IngredientDto {

    private UUID ingredientId;

    private String ingredientName;

    private double ingredientQuantity;

    public IngredientDto(){

    }

    public IngredientDto(UUID ingredientId, String ingredientName, double ingredientQuantity){
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.ingredientQuantity = ingredientQuantity;
    }

    public UUID getingredientId() {
        return ingredientId;
    }

    public String getingredientName() {
        return ingredientName;
    }

    public double getingredientQuantity() {
        return ingredientQuantity;
    }


    public void setingredientId(UUID ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setingredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setingredientQuantity(double ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }



}
