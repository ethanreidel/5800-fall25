package bridge;

public class PaypalPayment extends Payment {
    public PaypalPayment(Notification notif, float amount) {
        super(notif, amount);
    }

    @Override
    public void makePayment() {
        notif.send("Amount due: $" + amount + " in paypal balance");
    }
}
