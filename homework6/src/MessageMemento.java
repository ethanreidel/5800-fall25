import java.time.Instant;

public class MessageMemento {
    private final String content_snapshot;
    private final Instant timestamp_snapshot;
    private final Message original_message;

    public MessageMemento(Message original_message) {
        this.content_snapshot = original_message.text();
        this.timestamp_snapshot = original_message.timestamp();
        this.original_message = original_message;
    }

    public String get_content_snapshot() {
        return content_snapshot;
    }

    public Instant get_timestamp_snapshot() {
        return timestamp_snapshot;
    }

    public Message get_original_message() {
        return original_message;
    }
}