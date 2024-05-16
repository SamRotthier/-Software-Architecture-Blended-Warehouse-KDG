package be.kdg.sa.warehouse.domain;

import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="wa_order")
public class Order {

    @Id
    private UUID orderId;

    private Timestamp orderTimestamp;

    private UUID ingredientid;

    private int quantity;

    private OrderStatus orderStatus;


    public Order() {

    }

    public Order(UUID orderId, Timestamp orderTimestamp, UUID ingredientid, int quantity) {
        this.orderId = orderId;
        this.orderTimestamp = orderTimestamp;
        this.ingredientid = ingredientid;
        this.quantity = quantity;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Timestamp getOrderTimestamp() {
        return orderTimestamp;
    }

    public UUID getIngredientid() {
        return ingredientid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public void setOrderTimestamp(Timestamp orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public void setIngredientid(UUID ingredientid) {
        this.ingredientid = ingredientid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
