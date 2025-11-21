import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        Stock aapl = new Stock("AAPL", 100.00);

        aapl.setObserver(new ConcreteObserver());

        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            double pct = (rand.nextDouble() * 2 - 1) * 0.01;
            double next = Math.round((aapl.getPrice() * (1 + pct)) * 100.0) / 100.0;
            aapl.setPrice(next);
        }
    }
}
