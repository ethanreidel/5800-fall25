package Part2;

public class Driver {
    public static void main(String[] args) {
        MacronutrientFactory factory = DefaultMacronutrientFactory.getInstance();

        Customer customer1 = new Customer();
        customer1.setName("Ethan");
        customer1.setDietPlan(DietPlan.PALEO);
        Meal meal1 = factory.createBalancedMeal(customer1.getDietPlan());
        System.out.println(customer1.getName() + " -> " + meal1);

        Customer customer2 = new Customer();
        customer2.setName("Maya");
        customer2.setDietPlan(DietPlan.NO_RESTRICTION);
        Meal meal2 = factory.createBalancedMeal(customer2.getDietPlan());
        System.out.println(customer2.getName() + " -> " + meal2);

        Customer customer3 = new Customer();
        customer3.setName("Jordan");
        customer3.setDietPlan(DietPlan.VEGAN);
        Meal meal3 = factory.createBalancedMeal(customer3.getDietPlan());
        System.out.println(customer3.getName() + " -> " + meal3);

        Customer customer4 = new Customer();
        customer4.setName("Ava");
        customer4.setDietPlan(DietPlan.NUT_ALLERGY);
        Meal meal4 = factory.createBalancedMeal(customer4.getDietPlan());
        System.out.println(customer4.getName() + " -> " + meal4);

        Customer customer5 = new Customer();
        customer5.setName("Noah");
        customer5.setDietPlan(DietPlan.PALEO);
        Meal meal5 = factory.createBalancedMeal(customer5.getDietPlan());
        System.out.println(customer5.getName() + " -> " + meal5);

        Customer customer6 = new Customer();
        customer6.setName("Sofia");
        customer6.setDietPlan(DietPlan.VEGAN);
        Meal meal6 = factory.createBalancedMeal(customer6.getDietPlan());
        System.out.println(customer6.getName() + " -> " + meal6);
    }
}
