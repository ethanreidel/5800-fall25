package bridge;

public class CashPayment extends Payment {
    public CashPayment(Notification notif, float amount) {
        super(notif, amount);
    }
    
    @Override
    protected void makePayment() {
        notif.send("Amount due: $" + amount + " in cash");
    }
}
