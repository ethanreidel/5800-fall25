package Part2;

import java.util.List;

public class FatsFactory {
    private static final FatsFactory instance = new FatsFactory();
    private FatsFactory() {}

    public static FatsFactory getInstance() {
        return instance;
    }

    public Fats create(DietPlan plan) {
        List<Fats.FatsType> options = Fats.eligibleTypes(plan);
        if (options.isEmpty()) {
            throw new IllegalStateException("No eligible carbs for " + plan);
        }
        Fats.FatsType pick = Fats.pickRandom(plan);
        return new Fats(pick);
    }
}
