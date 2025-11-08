package src;

public class PaypalGateway {
    //payment amount and email
    public void process_payment(double amount, String email_address) {
        System.out.println("Paying via PayPal: $" + amount + " to email address: " + email_address);

    }
}
