package decorator;

public abstract class FoodDecorator implements Food {
    protected final Food decoratedFood;

    public FoodDecorator(Food decoratedFood) {
        this.decoratedFood = decoratedFood;
    }

    @Override
    public double calculateCost() {
        return decoratedFood.calculateCost();
    }
}
