import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChatAppTests {

    @Test
    void testSendAndReceive() {
        Mediator server = new ChatServer();
        User a = new User(server, "A");
        User b = new User(server, "B");

        a.send_message(b, "hello");
        var bSnap = b.getHistory().snapshot();
        var aSnap = a.getHistory().snapshot();

        assertEquals(1, bSnap.size(), "B should have 1 received message");
        assertEquals("A", bSnap.get(0).sender().get_name());
        assertEquals(1, aSnap.size(), "A should have 1 sent message recorded");
        assertEquals("hello", aSnap.get(0).text());
    }

    @Test
    void testBroadcast() {
        Mediator server = new ChatServer();
        User a = new User(server, "A");
        User b = new User(server, "B");
        User c = new User(server, "C");

        a.send_message(List.of(b, c), "team hi");
        assertEquals(1, b.getHistory().snapshot().size());
        assertEquals(1, c.getHistory().snapshot().size());
        assertEquals(1, a.getHistory().snapshot().size());
    }

    @Test
    void testBlock() {
        Mediator server = new ChatServer();
        User a = new User(server, "A");
        User b = new User(server, "B");

        b.block(a);
        a.send_message(b, "blocked?");
        assertEquals(0, b.getHistory().snapshot().size(), "B should not receive blocked message");
        assertEquals(1, a.getHistory().snapshot().size(), "A still has it recorded as sent");
    }

    @Test
    void testUndoRemovesFromRecipients() {
        Mediator server = new ChatServer();
        User a = new User(server, "A");
        User b = new User(server, "B");
        User c = new User(server, "C");

        a.send_message(List.of(b, c), "recall me");
        assertEquals(1, b.getHistory().snapshot().size());
        assertEquals(1, c.getHistory().snapshot().size());
        assertEquals(1, a.getHistory().snapshot().size());

        a.undo_previous_message();

        assertEquals(0, b.getHistory().snapshot().size(), "B should have message removed");
        assertEquals(0, c.getHistory().snapshot().size(), "C should have message removed");
        assertEquals(0, a.getHistory().snapshot().size(), "A should have message removed after undo");
    }

    @Test
    void testIteratorByUser() {
        Mediator server = new ChatServer();
        User a = new User(server, "A");
        User b = new User(server, "B");
        User c = new User(server, "C");

        a.send_message(b, "one");
        b.send_message(a, "two");
        a.send_message(c, "ignore for B");
        a.send_message(b, "three");

        Iterator<Message> it = b.iterator(a);
        int count = 0;
        while (it.hasNext()) {
            Message m = it.next();
            assertTrue(
                m.sender().get_name().equals("A")
                || m.recipients().stream().anyMatch(u -> u.get_name().equals("A"))
            );
            count++;
        }
        assertEquals(3, count, "B should see 3 messages with A");
    }
}
