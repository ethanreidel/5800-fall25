package bridge;

public class BridgeDriver3 {
    public static void main(String[] args) {
        Payment p1 = new CashPayment(new PushNotification(), 20);
        p1.makePayment();
        Payment p2 = new PaypalPayment(new PushNotification(), 80);
        p2.makePayment();
    }
}
