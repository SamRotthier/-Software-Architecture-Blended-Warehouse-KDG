package be.kdg.sa.warehouse.Senders;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class OrderMessage {
    private final UUID uuid;
    private String currentTime;

    public OrderMessage(UUID uuid) {
        this.uuid = uuid;
        this.currentTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    }
}
