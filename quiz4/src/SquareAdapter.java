package src;

public class SquareAdapter implements PaymentProcess {
    private SquareGateway square_gateway;
    private int location_id;

    public SquareAdapter(SquareGateway square_gateway, int location_id) {
        this.square_gateway = square_gateway;
        this.location_id = location_id;
    }

    @Override
    public void pay(double amount) {
        square_gateway.process_payment(amount, location_id);
    }

}
