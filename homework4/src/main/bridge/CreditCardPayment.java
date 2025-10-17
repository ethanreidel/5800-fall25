package bridge;

public class CreditCardPayment extends Payment{
    public CreditCardPayment(Notification notif, float amount) {
        super(notif, amount);
        
    }

    @Override
    protected void makePayment() {
        notif.send("Amount due: $" + amount + " billed on your credit card");
    }
}
