package be.kdg.sa.warehouse.receivers.messages;

public class ConfirmationMessage {
    private String message;


    public ConfirmationMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
