package chain;

import main.Snack;

public class CheetosHandler extends SnackHandler {

    private final Snack cheetosSnack;

    public CheetosHandler(Snack cheetosSnack) {
        this.cheetosSnack = cheetosSnack;
    }

    @Override
    public boolean handle(Snack requestedSnack, double moneyInserted) {
        if (!"Cheetos".equalsIgnoreCase(requestedSnack.getName())) {
            return handleNext(requestedSnack, moneyInserted);
        }

        if (requestedSnack.getQuantity() <= 0) {
            System.out.println("Cheetos are out of stock.");
            return false;
        }

        if (moneyInserted < cheetosSnack.getPrice()) {
            System.out.printf(
                "Not enough money for Cheetos. Price: $%.2f, inserted: $%.2f%n",
                requestedSnack.getPrice(), moneyInserted
            );
            return false;
        }

        requestedSnack.decreaseQuantity();
        System.out.println("Dispensing Cheetos...");
        return true;
    }
}
