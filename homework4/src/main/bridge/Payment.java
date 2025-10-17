package bridge;

public abstract class Payment {
    protected Notification notif; //acts as the bridge between classes (payment and notif)
    protected float amount;

    protected Payment(Notification notif, float amount) {
        this.notif = notif;
        this.amount = amount;
    }

    protected abstract void makePayment();

    public void pay() {
        makePayment();
    }
}
