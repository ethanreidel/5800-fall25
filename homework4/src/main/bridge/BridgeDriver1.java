package bridge;

public class BridgeDriver1 {
    public static void main(String[] args) {
        Payment p1 = new CashPayment(new EmailNotification(), 100);
        p1.makePayment();
        Payment p2 = new PaypalPayment(new SMSNotification(), 1000);
        p2.makePayment();
        Payment p3 = new CreditCardPayment(new SMSNotification(), 150);
        p3.makePayment();
        Payment p4 = new CashPayment(new SMSNotification(), 34);
        p4.makePayment();
    }
}
