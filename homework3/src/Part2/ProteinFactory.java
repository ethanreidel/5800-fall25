package Part2;

import java.util.List;

public class ProteinFactory {
    private static final ProteinFactory instance = new ProteinFactory();
    private ProteinFactory() {}

    public static ProteinFactory getInstance() {
        return instance;
    }

    public Protein create(DietPlan plan) {
        List<Protein.ProteinType> options = Protein.eligibleTypes(plan);
        if (options.isEmpty()) {
            throw new IllegalStateException("No eligible carbs for " + plan);
        }
        Protein.ProteinType pick = Protein.pickRandom(plan);
        return new Protein(pick);
    }
}
