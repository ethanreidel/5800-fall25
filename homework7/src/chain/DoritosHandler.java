package chain;

import main.Snack;

public class DoritosHandler extends SnackHandler {
    private final Snack doritosSnack;

    public DoritosHandler(Snack doritosSnack) {
        this.doritosSnack = doritosSnack;
    }

    @Override
    public boolean handle(Snack requestedSnack, double moneyInserted) {
        if (!"Doritos".equalsIgnoreCase(requestedSnack.getName())) {
            return handleNext(requestedSnack, moneyInserted);
        }

        if (doritosSnack.getQuantity() <= 0) {
            System.out.println("Doritos is out of stock.");
            return false;
        }

        if (moneyInserted < doritosSnack.getPrice()) {
            System.out.println("Not enough money for Doritos.");
            return false;
        }

        doritosSnack.decreaseQuantity();
        System.out.println("Dispensing Doritos...");
        return true;
    }
}
