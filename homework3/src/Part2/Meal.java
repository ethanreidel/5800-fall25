package Part2;


public class Meal {
    private Carbs carb;
    private Fats fat;
    private Protein protein;
    private DietPlan plan;

    public Meal(Carbs carb, Fats fat, Protein protein, DietPlan plan) {
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "Meal plan: " + plan + ". Contains: " + carb + ", " + fat + ", " + protein;
    }
}
