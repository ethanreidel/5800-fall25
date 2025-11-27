package chain;

import main.Snack;

public class CokeHandler extends SnackHandler {

    private final Snack cokeSnack;

    public CokeHandler(Snack cokeSnack) {
        this.cokeSnack = cokeSnack;
    }

    @Override
    public boolean handle(Snack requestedSnack, double moneyInserted) {
        if (!"Coke".equalsIgnoreCase(requestedSnack.getName())) {
            return handleNext(requestedSnack, moneyInserted);
        }

        if (cokeSnack.getQuantity() <= 0) {
            System.out.println("Coke is out of stock.");
            return false;
        }

        if (moneyInserted < cokeSnack.getPrice()) {
            System.out.println("Not enough money for Coke.");
            return false;
        }

        cokeSnack.decreaseQuantity();
        System.out.println("Dispensing Coke...");
        return true;
    }
}
