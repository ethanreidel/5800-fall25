package src;

public class StripeGateway{
    //payment amount, cardholder name, card number, expiration date
    public void process_payment(double amount, String name, int card_number, int expiration_date) {
        System.out.println("Using Stripe to pay: $" + amount + " with " + name + "'s card with card number: " + card_number + " and expiration date: " + expiration_date);
    }
}
