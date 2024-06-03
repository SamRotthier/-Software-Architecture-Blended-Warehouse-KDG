package be.kdg.sa.warehouse.domain;

import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.domain.Order;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "wa_orderIngredient")
public class OrderIngredient{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Ingredient ingredient;

    private Integer quantity;

    public OrderIngredient(UUID id, Order order, Ingredient ingredient, Integer quantity) {
        this.id = id;
        this.order = order;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }


    public OrderIngredient() {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Integer getQuantity() {
        return quantity;
    }
}