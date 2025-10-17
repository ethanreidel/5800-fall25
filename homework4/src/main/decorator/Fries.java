package decorator;

    
public class Fries implements Food {
    private double basePrice;
    public Fries(double basePrice) {
        this.basePrice = basePrice;
    }
    @Override
    public double calculateCost() {
        return basePrice;
    }

}


