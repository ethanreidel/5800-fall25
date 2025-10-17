package test.decorator;
import decorator.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToppingDecoratorTest {

    private static final double EPS = 1e-9;

    @Test
    void baseBurgerHasBasePrice() {
        Food burger = new Burger(5.00);
        assertEquals(5.00, burger.calculateCost(), EPS);
    }

    @Test
    void burgerWithSingleToppingAddsPrice() {
        Food burger = new Burger(5.00);
        burger = new ToppingDecorator(burger, "Cheese", 1.00);

        assertEquals(6.00, burger.calculateCost(), EPS);
    }

    @Test
    void burgerWithMultipleToppingsStacksProperly() {
        Food burger = new Burger(5.00);
        burger = new ToppingDecorator(burger, "Cheese", 1.00);
        burger = new ToppingDecorator(burger, "Ketchup", 0.25);
        burger = new ToppingDecorator(burger, "Onions", 0.30);

        assertEquals(6.55, burger.calculateCost(), EPS);
    }

    @Test
    void ensureLoyaltyWorksProperly() {
        Food burger = new Burger(5.00);
        burger = new ToppingDecorator(burger, "Cheese", 1.00);
        burger = new ToppingDecorator(burger, "Ketchup", 0.25);
        burger = new ToppingDecorator(burger, "Onions", 0.30);

        Order order = new Order();
        order.addItem(burger);

        Loyalty gold = new Loyalty(LoyaltyTier.GOLD, 0, 0.05, .10);
        assertEquals(5.895, gold.apply(burger.calculateCost()), EPS);
    }
}
