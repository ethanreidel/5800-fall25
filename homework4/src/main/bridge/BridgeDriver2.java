package bridge;

public class BridgeDriver2 {
    public static void main(String[] args) {
        Payment btcPayment = new BitcoinPayment(new EmailNotification(), 1);
        btcPayment.makePayment();
        Payment btcPayment2 = new BitcoinPayment(new SMSNotification(), .5F);
        btcPayment2.makePayment();

    }
}
