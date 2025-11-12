import java.util.List;

public interface Mediator {
    void send_message(User from, User to, Message message);
    void send_message(User from, List<User> to_list, Message message);
    void register_user(User user);
    void unregister_user(User user);
    void block_messages(User blocker, User blockee);
    void unblock_messages(User blocker, User blockee);
    void undo_last_message(User who);
}