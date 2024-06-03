package be.kdg.sa.warehouse.domain;

import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="wa_order")
public class Order {

    @Id
    private UUID orderId;

    private Instant orderTimestamp;

    @OneToMany(mappedBy = "order")
    private List<OrderIngredient> ingredients;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    public Order() {
    }

    public Order(UUID orderId, Instant orderTimestamp, UUID ingredientid, int quantity) {
        this.orderId = orderId;
        this.orderTimestamp = orderTimestamp;
    }

    public UUID getOrderId() {
        return orderId;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public Instant getOrderTimestamp() {
        return orderTimestamp;
    }
    public List<OrderIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<OrderIngredient> ingredients) {
        this.ingredients = ingredients;
    }
    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
    public void setOrderTimestamp(Instant orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
