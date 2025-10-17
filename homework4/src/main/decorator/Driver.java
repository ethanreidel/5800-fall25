package decorator;

public class Driver {
    public static void main(String[] args) {
        Food burger = new Burger(10);
        burger = new ToppingDecorator(burger, "cheese", 5);
        burger = new ToppingDecorator(burger, "lettuce", 1);

        Food fries = new Fries(15);
        fries = new ToppingDecorator(fries, "chili", 7);
        fries = new ToppingDecorator(fries, "onions", 2);

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);

        System.out.println("Subtotal = $" + order.calculateSubtotal());

        Loyalty gold = new Loyalty(LoyaltyTier.GOLD, 0, 0.05, .10);

        System.out.println("Total with gold loyalty plan: " + gold.apply(order.calculateSubtotal()));

    }
}
