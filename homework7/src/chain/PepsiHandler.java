package chain;

import main.Snack;

public class PepsiHandler extends SnackHandler {

    private final Snack pepsiSnack;

    public PepsiHandler(Snack pepsiSnack) {
        this.pepsiSnack = pepsiSnack;
    }

    @Override
    public boolean handle(Snack requestedSnack, double moneyInserted) {
        if (!"Pepsi".equalsIgnoreCase(requestedSnack.getName())) {
            return handleNext(requestedSnack, moneyInserted);
        }

        if (requestedSnack.getQuantity() <= 0) {
            System.out.println("Pepsi is out of stock.");
            return false;
        }

        if (moneyInserted < pepsiSnack.getPrice()) {
            System.out.printf(
                "Not enough money for Pepsi. Price: $%.2f, inserted: $%.2f%n",
                pepsiSnack.getPrice(), moneyInserted
            );
            return false;
        }

        requestedSnack.decreaseQuantity();
        System.out.println("Dispensing Pepsi...");
        return true;
    }
}
