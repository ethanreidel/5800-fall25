package chain;

import main.Snack;

public class SnickersHandler extends SnackHandler {

    private final Snack snickersSnack;

    public SnickersHandler(Snack snickersSnack) {
        this.snickersSnack = snickersSnack;
    }

    @Override
    public boolean handle(Snack requestedSnack, double moneyInserted) {
        if (!"Snickers".equalsIgnoreCase(requestedSnack.getName())) {
            return handleNext(requestedSnack, moneyInserted);
        }

        if (snickersSnack.getQuantity() <= 0) {
            System.out.println("Snickers is out of stock.");
            return false;
        }

        if (moneyInserted < snickersSnack.getPrice()) {
            System.out.println("Not enough money for Snickers.");
            return false;
        }

        snickersSnack.decreaseQuantity();
        System.out.println("Dispensing Snickers...");
        return true;
    }
    
}
