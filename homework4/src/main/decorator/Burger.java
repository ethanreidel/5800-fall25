package decorator;

public class Burger implements Food {
    private double basePrice;
    public Burger(double basePrice) {
        this.basePrice = basePrice;
    }
    @Override
    public double calculateCost() {
        return basePrice;
    }

}
