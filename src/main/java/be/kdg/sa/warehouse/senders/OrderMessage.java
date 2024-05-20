package be.kdg.sa.warehouse.senders;

import be.kdg.sa.warehouse.domain.Enum.OrderStatus;
import be.kdg.sa.warehouse.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;

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
