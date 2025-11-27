package chain;

import main.Snack;

public abstract class SnackHandler {
    private SnackHandler next;

    public SnackHandler setNextHandler(SnackHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(Snack snack, double priceInserted);

    protected boolean handleNext(Snack snack, double priceInserted) {
        if (next == null) {
            return false;
        }
        return next.handle(snack, priceInserted);
    }
}
