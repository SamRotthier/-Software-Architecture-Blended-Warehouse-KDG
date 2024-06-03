package be.kdg.sa.warehouse.senders;

import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import be.kdg.sa.warehouse.domain.Order;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.UUID;

public class OrderMessage {
    private final UUID uuid;
    @CreationTimestamp
    private Instant currentTime;
    private OrderStatus orderStatus;


    public OrderMessage(Order order) {
        this.uuid = order.getOrderId();
        this.orderStatus = order.getOrderStatus();
    }
}
