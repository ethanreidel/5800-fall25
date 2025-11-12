import java.util.*;

public class ChatServer implements Mediator {
    private final Set<User> users = new HashSet<>();
    private final Map<User, Set<User>> blocked_by_user = new HashMap<>();

    @Override
    public void send_message(User from, User user_to_send_message_to, Message message) {
        if (!users.contains(from) || !users.contains(user_to_send_message_to)) {
            return;
        }
        Set<User> blocked = blocked_by_user.getOrDefault(user_to_send_message_to, Collections.emptySet());
        if (blocked.contains(from)) {
            System.out.println(user_to_send_message_to.get_name() + " blocks messages from " + from.get_name());
            return;
        }
        System.out.println("Sending message to: " + user_to_send_message_to.get_name());
        user_to_send_message_to.recieve_message(message, from);
    }

    @Override
    public void send_message(User from, List<User> to_list, Message message) {
        for (User to : to_list) {
            send_message(from, to, message);
        }
    }

    @Override
    public void register_user(User user) {
        users.add(user);
        user.set_mediator(this);
    }

    @Override
    public void unregister_user(User user) {
        users.remove(user);
        user.set_mediator(null);
        blocked_by_user.remove(user);
        blocked_by_user.values().forEach(set -> set.remove(user));
    }

    @Override
    public void block_messages(User blocker, User blockee) {
        blocked_by_user.computeIfAbsent(blocker, k -> new HashSet<>()).add(blockee);
    }

    @Override
    public void unblock_messages(User blocker, User blockee) {
        Set<User> set = blocked_by_user.get(blocker);
        if (set != null) {
            set.remove(blockee);
            if (set.isEmpty()) {
                blocked_by_user.remove(blocker);
            }
        }
    }

    @Override
    public void undo_last_message(User who) {
        // get the original message from the user's history via memento stack
        Message original = who.getHistory().pop_last_sent_original();
        if (original == null) {
            System.out.println(who.get_name() + " has no message to undo.");
            return;
        }

        for (User r : original.recipients()) {
            if (users.contains(r)) {
                boolean removed = r.remove_message_from_history(original);
                if (removed) {
                    System.out.printf("[SYSTEM] '%s' message at %s recalled from %s%n",
                            who.get_name(), original.timestamp(), r.get_name());
                }
            }
        }

        who.remove_message_from_history(original);
    }
}
