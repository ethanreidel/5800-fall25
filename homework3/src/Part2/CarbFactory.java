package Part2;

import java.util.List;

public class CarbFactory {
    private static final CarbFactory instance = new CarbFactory();
    private CarbFactory() {}

    public static CarbFactory getInstance() {
        return instance;
    }

    public Carbs create(DietPlan plan) {
        List<Carbs.CarbType> options = Carbs.eligibleTypes(plan);
        if (options.isEmpty()) {
            throw new IllegalStateException("No eligible carbs for " + plan);
        }
        Carbs.CarbType pick = Carbs.pickRandom(plan);
        return new Carbs(pick);
    }

    
}
