import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser {
    private final List<Message> timeline = new ArrayList<>();
    private final Deque<MessageMemento> sent_snapshots = new ArrayDeque<>();

 
    public void add_sent(Message m) {
        timeline.add(m);
        sent_snapshots.push(new MessageMemento(m));
    }

    public void add_received(Message m) {
        timeline.add(m);
    }

    public MessageMemento peek_last_sent_memento() {
        return sent_snapshots.peek();
    }

    public Message pop_last_sent_original() {
        MessageMemento mm = sent_snapshots.poll();
        return mm == null ? null : mm.get_original_message();
    }
    public boolean remove(Message message) {
        return timeline.remove(message);
    }

    public List<Message> snapshot() {
        return List.copyOf(timeline);
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return new SearchMessagesByUser(snapshot(), userToSearchWith);
    }
}