package be.kdg.sa.warehouse.domain;

import be.kdg.sa.warehouse.domain.Enum.ExpZone;
import be.kdg.sa.warehouse.domain.Enum.FireZone;
import be.kdg.sa.warehouse.domain.Enum.TempZone;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="wa_ingredient")
public class Ingredient {

    @Id
    private UUID ingredientId;
    private String name;
    private Integer quantity;
    private ExpZone experationZone;
    private TempZone temperatureZone;
    private FireZone fireZone;

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

    public Ingredient(UUID ingredientId, String name, Integer quantity, ExpZone experationZone, TempZone temperatureZone, FireZone fireZone) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.quantity = quantity;
        this.experationZone = experationZone;
        this.temperatureZone = temperatureZone;
        this.fireZone = fireZone;
    }

    public UUID getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(UUID ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ExpZone getExperationZone() {
        return experationZone;
    }

    public void setExperationZone(ExpZone experationZone) {
        this.experationZone = experationZone;
    }

    public TempZone getTemperatureZone() {
        return temperatureZone;
    }

    public void setTemperatureZone(TempZone temperatureZone) {
        this.temperatureZone = temperatureZone;
    }

    public FireZone getFireZone() {
        return fireZone;
    }

    public void setFireZone(FireZone fireZone) {
        this.fireZone = fireZone;
    }

    public List<ProductIngredient> getProducts() {
        return products;
    }

    public void setProducts(List<ProductIngredient> products) {
        this.products = products;
    }
}
