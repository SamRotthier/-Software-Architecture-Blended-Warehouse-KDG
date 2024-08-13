package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "wa_productIngredient")
public class ProductIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Product product;
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