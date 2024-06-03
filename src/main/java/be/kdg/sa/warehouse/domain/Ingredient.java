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

    private String name;

    private Integer quantity;

    @OneToMany(mappedBy = "ingredient")
    private List<ProductIngredient> products;


    public Ingredient(){

    }

    public Ingredient(UUID ingredientId, String ingredientName){
        this.ingredientId = ingredientId;
        this.name = ingredientName;
    }

    public Ingredient(UUID ingredientId, String ingredientName, Integer quantity){
        this.ingredientId = ingredientId;
        this.name = ingredientName;
        this.quantity = quantity;
    }

    public Ingredient(UUID ingredientId, String ingredientName, List<ProductIngredient> products) {
        this.ingredientId = ingredientId;
        this.name = ingredientName;
        this.products = products;
    }

    public UUID getingredientId() {
        return ingredientId;
    }

    public String getingredientName() {
        return name;
    }

    public double getingredientQuantity() {
        return quantity;
    }


    public void setingredientId(UUID ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setName(String ingredientName) {
        this.name = ingredientName;
    }

    public void setingredientQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
