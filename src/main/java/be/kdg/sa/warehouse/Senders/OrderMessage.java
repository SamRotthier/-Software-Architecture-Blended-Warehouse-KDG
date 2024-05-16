package be.kdg.sa.warehouse.Senders;

import be.kdg.sa.warehouse.domain.Enum.OrderStatus;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class OrderMessage {
    private final UUID uuid;
    private String currentTime;
    private OrderStatus orderStatus;



    public OrderMessage(UUID uuid, OrderStatus orderStatus) {
        this.uuid = uuid;
        this.currentTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    }
}
