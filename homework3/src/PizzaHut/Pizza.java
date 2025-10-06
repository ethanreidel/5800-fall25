package PizzaHut;

import java.util.List;
import java.util.ArrayList;


public class Pizza {
    public enum Topping {
        PEPPERONI, SAUSAGE, MUSHROOMS, BACON, ONIONS, EXTRA_CHEESE,
        PEPPERS, CHICKEN, OLIVES, SPINACH, TOMATO_BASIL, BEEF,
        HAM, PESTO, SPICY_PORK, HAM_AND_PINEAPPLE
    };
    public enum Size {SMALL, MEDIUM, LARGE};

    private final String pizzaChain;
    private final List<Topping> toppings;
    private final Size size;

    private Pizza(Builder pizzaBuilder) {
        this.pizzaChain = pizzaBuilder.pizzaChain;
        this.toppings = List.copyOf(pizzaBuilder.toppings);
        this.size = pizzaBuilder.size;
    }

    public void eat() {
        System.out.println(
            "Pizza chain: " + pizzaChain + "\n" +
            "Size: " + size
        );
        System.out.println("Toppings: " + toppings.toString());
    }

    public static class Builder {
        private String pizzaChain;
        private ArrayList<Topping> toppings = new ArrayList<>();
        private Size size;

        public Builder() {}
        public Builder setChain(String pizzaChain) {
            this.pizzaChain = pizzaChain;
            return this;
        }
        public Builder addTopping(Topping topper) {
            toppings.add(topper);
            return this;
        }
        public Builder setSize(Size size) {
            this.size = size;
            return this;
        }
        public Pizza buildPizza() {
            if (size == null) {
                throw new IllegalStateException("Size is required.");
            }
            return new Pizza(this);
        }
    }
}
