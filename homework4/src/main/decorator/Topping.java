package decorator;

public abstract class Topping {
    private double toppingPrice;

    public Topping(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }
}
