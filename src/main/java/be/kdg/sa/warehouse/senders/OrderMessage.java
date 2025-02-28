package be.kdg.sa.warehouse.senders;

import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import java.time.Instant;
import java.util.UUID;

public class OrderMessage {
    private final UUID id;
    private Instant currentTime;
    private OrderStatus orderStatus;

    public OrderMessage(UUID id, Instant currentTime, OrderStatus orderStatus) {
        this.id = id;
        this.currentTime = currentTime;
        this.orderStatus = orderStatus;
    }

    public UUID getId() {
        return id;
    }

    public Instant getCurrentTime() {
        return currentTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }


    public void setCurrentTime(Instant currentTime) {
        this.currentTime = currentTime;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
