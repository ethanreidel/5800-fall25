package decorator;

import java.util.List;
import java.util.ArrayList;

public class Order {
    private final List<Food> items = new ArrayList<>();

    public void addItem(Food item) {
        items.add(item);
    }

    public void removeItem(Food item) {
        items.remove(item);
    }

    public double calculateSubtotal() {
        double sum = 0;
        for (Food food : items) {
            sum += food.calculateCost();
        }
        return sum;
    }


}
