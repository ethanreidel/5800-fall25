package bridge;

public class BitcoinPayment extends Payment {
    public BitcoinPayment(Notification notif, float amount) {
        super(notif, amount);
    }
    @Override
    protected void makePayment() {
        notif.send("Amount due in BTC: " + amount);
    }
}
