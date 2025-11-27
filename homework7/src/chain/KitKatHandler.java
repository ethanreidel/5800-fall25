package chain;

import main.Snack;

public class KitKatHandler extends SnackHandler {

    public final Snack kitkatSnack;

    public KitKatHandler(Snack kitkatSnack) {
        this.kitkatSnack = kitkatSnack;
    }

    @Override
    public boolean handle(Snack requestedSnack, double moneyInserted) {
        if (!"KitKat".equalsIgnoreCase(requestedSnack.getName())) {
            return handleNext(requestedSnack, moneyInserted);
        }

        if (requestedSnack.getQuantity() <= 0) {
            System.out.println("KitKat is out of stock.");
            return false;
        }
        if (moneyInserted < kitkatSnack.getPrice()) {
            System.out.printf(
                "Not enough money for KitKat. Price: $%.2f, inserted: $%.2f%n",
                kitkatSnack.getPrice(), moneyInserted
            );
            return false;
        }

        requestedSnack.decreaseQuantity();
        System.out.println("Dispensing KitKat...");
        return true;
    }
}
