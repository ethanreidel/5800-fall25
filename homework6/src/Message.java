import java.util.List;
import java.util.ArrayList;
import java.time.Instant;
import java.util.Objects;

public class Message {
    private final User sender;
    private final List<User> recipients; // always non-null (single recipient wrapped into a list)
    private final Instant timestamp;
    private final String message_content;

    public Message(User sender, User recipient, Instant timestamp, String message_content) {
        this.sender = sender;
        this.recipients = new ArrayList<>();
        this.recipients.add(recipient);
        this.timestamp = timestamp;
        this.message_content = message_content;
    }

    public Message(User sender, List<User> recipients, Instant timestamp, String message_content) {
        this.sender = sender;
        this.recipients = new ArrayList<>(recipients);
        this.timestamp = timestamp;
        this.message_content = message_content;
    }

    public String text() { return message_content; }
    public User sender() { return sender; }
    public List<User> recipients() { return new ArrayList<>(recipients); }
    public Instant timestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Message{" +
                "from=" + (sender == null ? "null" : sender.get_name()) +
                ", to=" + recipients.stream().map(User::get_name).toList() +
                ", at=" + timestamp +
                ", text='" + message_content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message msg)) return false;
        return Objects.equals(sender.get_name(), msg.sender.get_name())
                && Objects.equals(timestamp, msg.timestamp)
                && Objects.equals(message_content, msg.message_content)
                && recipients.size() == msg.recipients.size()
                && recipients.stream().map(User::get_name).sorted().toList()
                   .equals(msg.recipients.stream().map(User::get_name).sorted().toList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender.get_name(), timestamp, message_content,
                recipients.stream().map(User::get_name).sorted().toList());
    }
}