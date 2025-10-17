package decorator;

public class ToppingDecorator extends FoodDecorator {
    private String name;
    private double toppingPrice;
    public ToppingDecorator(Food decorator, String name, double toppingPrice) {
        super(decorator);
        this.name = name;
        this.toppingPrice = toppingPrice;
    }
    @Override
    public double calculateCost() {
        return super.calculateCost() + toppingPrice;
    }
    
}
