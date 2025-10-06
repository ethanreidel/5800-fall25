package Part2;

public interface MacronutrientFactory {
    Carbs createCarb(DietPlan plan);
    Protein createProtein(DietPlan plan);
    Fats createFat(DietPlan plan);

    default Meal createBalancedMeal(DietPlan plan) {
        return new Meal(createCarb(plan), createFat(plan), createProtein(plan), plan);
    }
}
