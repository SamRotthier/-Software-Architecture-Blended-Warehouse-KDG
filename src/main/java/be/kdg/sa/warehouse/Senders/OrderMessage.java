package be.kdg.sa.warehouse.Senders;

import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import be.kdg.sa.warehouse.domain.Order;
import be.kdg.sa.warehouse.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class OrderMessage {
    private final UUID uuid;
    private String currentTime;
    private OrderStatus orderStatus;

    @Autowired
    public OrderMessage(Order order) {
        this.uuid = order.getOrderId();
        this.currentTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        this.orderStatus = order.getOrderStatus();
    }
}
