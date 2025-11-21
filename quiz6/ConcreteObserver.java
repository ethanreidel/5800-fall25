public class ConcreteObserver implements Observer {
    private Double previousPrice = null;

    public ConcreteObserver() {}
         
    @Override
    public void update(String symbol, double price) {
        String direction;
        if (previousPrice == null) { //need this if first iteration
            direction = "First day of stock, no change";
        } else if (price > previousPrice) {
            direction = "Price went up by $" + String.format("%.2f", price - previousPrice);
        } else if (price < previousPrice) {
            direction = "Price went down by $" + String.format("%.2f", previousPrice - price);
        } else {
            direction = "No change in price.";
        }
        previousPrice = price;
        System.out.printf("Stock: %s. Price: %.2f. %s.\n", symbol, price, direction);
    }
}
