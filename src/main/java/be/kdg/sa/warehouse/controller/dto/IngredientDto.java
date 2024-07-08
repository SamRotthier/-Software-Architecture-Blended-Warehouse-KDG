package be.kdg.sa.warehouse.controller.dto;

import java.util.UUID;

public class IngredientDto {

    private UUID ingredientId;

    private String Name;

    private int Quantity;

    public IngredientDto(){

    }

    public IngredientDto(UUID ingredientId, String Name, int Quantity){
        this.ingredientId = ingredientId;
        this.Name = Name;
        this.Quantity = Quantity;
    }

    public UUID getingredientId() {
        return ingredientId;
    }

    public String getingredientName() {
        return Name;
    }

    public int getingredientQuantity() {
        return Quantity;
    }


    public void setingredientId(UUID ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setingredientName(String Name) {
        this.Name = Name;
    }

    public void setingredientQuantity(int Quantity) {
        this.Quantity = Quantity;
    }



}
