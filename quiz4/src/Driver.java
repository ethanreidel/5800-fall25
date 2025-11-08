package src;
public class Driver {
    public static void main(String[] args) {
        PaypalGateway paypal_gateway = new PaypalGateway();
        PaypalAdapter paypal_adapter = new PaypalAdapter(paypal_gateway, "ethanreidel@cpp.edu");
        Service paypal_service = new Service(paypal_adapter);
        paypal_service.perform_transaction(29.99);

        StripeGateway stripe_gateway = new StripeGateway();
        StripeAdapter stripe_adapter = new StripeAdapter(stripe_gateway, "ethan", 411133322, 10132001);
        Service stripe_service = new Service(stripe_adapter);
        stripe_service.perform_transaction(59.99);

        SquareGateway square_gateway = new SquareGateway();
        SquareAdapter square_adapter = new SquareAdapter(square_gateway, 3);
        Service square_service = new Service(square_adapter);
        square_service.perform_transaction(100.99);

        //checking if we can use any adapter
        Service random_service = new Service(stripe_adapter);
        random_service.perform_transaction(3000.00);
    }
}
