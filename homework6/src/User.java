import java.time.Instant;
import java.util.List;
import java.util.Iterator;

public class User implements IterableByUser {
    private Mediator mediator;
    private final String name;
    private final ChatHistory history = new ChatHistory();

    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.register_user(this);
    }

    void set_mediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send_message(User user_to_send_message_to, String content) {
        ensure_registered();
        Message m = new Message(this, user_to_send_message_to, Instant.now(), content);
        history.add_sent(m);
        mediator.send_message(this, user_to_send_message_to, m);
    }

    public void send_message(List<User> users_to_send_message_to, String content) {
        ensure_registered();
        Message m = new Message(this, users_to_send_message_to, Instant.now(), content);
        history.add_sent(m);
        mediator.send_message(this, users_to_send_message_to, m);
    }

    public void recieve_message(Message message, User from) {
        System.out.printf("[%s] from %s: %s%n", name, from.get_name(), message.text());
        history.add_received(message);
    }

    public void undo_previous_message() {
        ensure_registered();
        mediator.undo_last_message(this);
    }

    public void block(User who) {
        ensure_registered();
        mediator.block_messages(this, who);
    }

    public void unblock(User who) {
        ensure_registered();
        mediator.unblock_messages(this, who);
    }

    public ChatHistory getHistory() {
        return history;
    }

    public boolean remove_message_from_history(Message message) {
        return history.remove(message);
    }

    private void ensure_registered() {
        if (mediator == null) {
            throw new IllegalStateException("User not registered");
        }
    }

    public String get_name() {
        return name;
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return history.iterator(userToSearchWith);
    }
}