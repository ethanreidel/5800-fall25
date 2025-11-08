package src;

public class SquareGateway {
    public void process_payment(double amount, int location_id) {
        System.out.println("Using Square to pay $" + amount + " using location id: " + location_id);
    } 
}
