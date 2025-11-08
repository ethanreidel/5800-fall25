package src;

public class StripeAdapter implements PaymentProcess {
    private StripeGateway stripe_gateway;
    private String name;
    private int card_number;
    private int expiration_date;
    
    public StripeAdapter(StripeGateway stripe_gateway, String name, int card_number, int expiration_date) {
        this.stripe_gateway = stripe_gateway;
        this.name = name;
        this.card_number = card_number;
        this.expiration_date = expiration_date;
    }

    @Override
    public void pay(double amount) {
        stripe_gateway.process_payment(amount, name, card_number, expiration_date);
    }

}


