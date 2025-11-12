import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchMessagesByUser implements Iterator<Message> {
    private final List<Message> snapshot;
    private final String targetName;
    private int index = 0;
    private Message next;

    public SearchMessagesByUser(List<Message> snapshot, User target) {
        this.snapshot = snapshot;
        this.targetName = target.get_name();
        advance();
    }

    private void advance() {
        next = null;
        while (index < snapshot.size()) {
            Message m = snapshot.get(index++);
            boolean involves = m.sender().get_name().equals(targetName) ||
                    m.recipients().stream().anyMatch(u -> u.get_name().equals(targetName));
            if (involves == true) {
                next = m;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Message next() {
        if (next == null) throw new NoSuchElementException();
        Message current = next;
        advance();
        return current;
    }
}