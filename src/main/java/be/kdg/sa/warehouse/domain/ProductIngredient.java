package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "wa_productIngredient")
//@IdClass(OrderIngredientId.class)
public class ProductIngredient {

    @Id
    @ManyToOne
    private Product product;

    @Id
    @ManyToOne
    private Ingredient ingredient;

    private int quantity;

    public ProductIngredient() {
    }

    public ProductIngredient(Product product, Ingredient ingredient, int quantity) {
        this.product = product;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

}