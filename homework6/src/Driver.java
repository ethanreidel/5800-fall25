import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Mediator server = new ChatServer();

        User alice = new User(server, "Alice");
        User bob   = new User(server, "Bob");
        User cara  = new User(server, "Cara");

        alice.send_message(bob, "Hi Bob!");
        bob.send_message(alice, "Hey Alice!");
        alice.send_message(List.of(bob, cara), "Hello both!");

        bob.block(alice);
        alice.send_message(bob, "You shouldn't see this, Bob.");

        alice.undo_previous_message();

        System.out.println("--- Bob's messages with Alice ---");
        var it = bob.iterator(alice);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
