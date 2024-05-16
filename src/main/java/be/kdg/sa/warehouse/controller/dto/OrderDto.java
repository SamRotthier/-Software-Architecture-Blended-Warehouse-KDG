package be.kdg.sa.warehouse.controller.dto;

import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.util.UUID;

public class OrderDto {

    @Id
    private UUID orderId;

    private Timestamp orderTimestamp;

    private UUID ingredientid;

    private int quantity;

    private OrderStatus orderStatus;


    public OrderDto() {

    }

    public OrderDto(UUID orderId, Timestamp orderTimestamp, UUID ingredientid, int quantity) {
        this.orderId = orderId;
        this.orderTimestamp = orderTimestamp;
        this.ingredientid = ingredientid;
        this.quantity = quantity;
    }

    public UUID getOrderId() {
        return orderId;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
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
