package PizzaHut;

public class PizzaHutDriver {
    public static void main(String[] args) {
        //PART 1
        Pizza small3 = new Pizza.Builder()
            .setChain("Pizza Hut")
            .setSize(Pizza.Size.SMALL)
            .addTopping(Pizza.Topping.PEPPERONI)
            .addTopping(Pizza.Topping.MUSHROOMS)
            .addTopping(Pizza.Topping.EXTRA_CHEESE)
            .buildPizza();
        small3.eat();
        System.out.println();

        Pizza medium6 = new Pizza.Builder()
            .setChain("Pizza Hut")
            .setSize(Pizza.Size.MEDIUM)
            .addTopping(Pizza.Topping.SAUSAGE)
            .addTopping(Pizza.Topping.ONIONS)
            .addTopping(Pizza.Topping.PEPPERS)
            .addTopping(Pizza.Topping.OLIVES)
            .addTopping(Pizza.Topping.SPINACH)
            .addTopping(Pizza.Topping.BACON)
            .buildPizza();
        medium6.eat();
        System.out.println();

        Pizza large9 = new Pizza.Builder()
            .setChain("Pizza Hut")
            .setSize(Pizza.Size.LARGE)
            .addTopping(Pizza.Topping.PEPPERONI)
            .addTopping(Pizza.Topping.SAUSAGE)
            .addTopping(Pizza.Topping.MUSHROOMS)
            .addTopping(Pizza.Topping.BACON)
            .addTopping(Pizza.Topping.ONIONS)
            .addTopping(Pizza.Topping.EXTRA_CHEESE)
            .addTopping(Pizza.Topping.PEPPERS)
            .addTopping(Pizza.Topping.CHICKEN)
            .addTopping(Pizza.Topping.OLIVES)
            .buildPizza();
        large9.eat();
        System.out.println();

        //PART 2
        Pizza phLarge3 = new Pizza.Builder()
                .setChain("Pizza Hut")
                .setSize(Pizza.Size.LARGE)
                .addTopping(Pizza.Topping.PEPPERONI)
                .addTopping(Pizza.Topping.MUSHROOMS)
                .addTopping(Pizza.Topping.EXTRA_CHEESE)
                .buildPizza();
        phLarge3.eat();
        System.out.println();

        Pizza phSmall2 = new Pizza.Builder()
                .setChain("Pizza Hut")
                .setSize(Pizza.Size.SMALL)
                .addTopping(Pizza.Topping.ONIONS)
                .addTopping(Pizza.Topping.PEPPERS)
                .buildPizza();
        phSmall2.eat();
        System.out.println();

        Pizza lcMedium8 = new Pizza.Builder()
                .setChain("Little Caesars")
                .setSize(Pizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.BACON)
                .addTopping(Pizza.Topping.ONIONS)
                .addTopping(Pizza.Topping.EXTRA_CHEESE)
                .addTopping(Pizza.Topping.PEPPERS)
                .addTopping(Pizza.Topping.CHICKEN)
                .addTopping(Pizza.Topping.OLIVES)
                .addTopping(Pizza.Topping.SPINACH)
                .buildPizza();
        lcMedium8.eat();
        System.out.println();

        Pizza lcSmall6 = new Pizza.Builder()
                .setChain("Little Caesars")
                .setSize(Pizza.Size.SMALL)
                .addTopping(Pizza.Topping.PEPPERONI)
                .addTopping(Pizza.Topping.MUSHROOMS)
                .addTopping(Pizza.Topping.TOMATO_BASIL)
                .addTopping(Pizza.Topping.BEEF)
                .addTopping(Pizza.Topping.ONIONS)
                .addTopping(Pizza.Topping.OLIVES)
                .buildPizza();
        lcSmall6.eat();
        System.out.println();

        Pizza dSmall1 = new Pizza.Builder()
                .setChain("Dominos")
                .setSize(Pizza.Size.SMALL)
                .addTopping(Pizza.Topping.PEPPERONI)
                .buildPizza();
        dSmall1.eat();
        System.out.println();

        Pizza dLarge3 = new Pizza.Builder()
                .setChain("Dominos")
                .setSize(Pizza.Size.LARGE)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.MUSHROOMS)
                .addTopping(Pizza.Topping.EXTRA_CHEESE)
                .buildPizza();
        dLarge3.eat();
        System.out.println();
    }
}
