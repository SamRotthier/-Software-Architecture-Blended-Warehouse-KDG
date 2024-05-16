package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="wa_ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ingredientId;

    private String ingredientName;

    private double ingredientQuantity;


    public Ingredient(){

    }

    public Ingredient(UUID ingredientId, String ingredientName){
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public Ingredient(UUID ingredientId, String ingredientName, double ingredientQuantity){
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
