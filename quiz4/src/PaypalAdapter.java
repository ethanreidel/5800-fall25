package src;

public class PaypalAdapter implements PaymentProcess {
    private PaypalGateway paypal_gateway;
    private String email;
    
    public PaypalAdapter(PaypalGateway paypal_gateway, String email) {
        this.paypal_gateway = paypal_gateway;
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        paypal_gateway.process_payment(amount, email);
    }

}
