package Part2;

import java.util.*;

public class Protein implements Food {
    public enum ProteinType {
        FISH, CHICKEN, BEEF, TOFU
    }

    public enum Tag {
        DAIRY, NUT, MEAT, NONE
    }

    private static final Map<ProteinType, Tag> proteinTagMap = Map.of(
        ProteinType.FISH,       Tag.MEAT,
        ProteinType.CHICKEN,    Tag.MEAT,
        ProteinType.BEEF,       Tag.MEAT,
        ProteinType.TOFU,       Tag.NONE
    );

    private final ProteinType type;

    public Protein(ProteinType type) {
        this.type = type;
    }

    public static List<ProteinType> eligibleTypes(DietPlan plan) {
        List<ProteinType> all = Arrays.asList(ProteinType.values());
        switch (plan) {
            case NO_RESTRICTION -> {
                return all;
            }
            case PALEO -> {
                return filterProteinOut(all, Set.of(Tag.DAIRY));
            }
            case VEGAN -> {
                return filterProteinOut(all, Set.of(Tag.MEAT, Tag.DAIRY));
            }
            case NUT_ALLERGY -> {
                return filterProteinOut(all, Set.of(Tag.NUT));
            }
            default -> throw new IllegalArgumentException("Unknown plan: " + plan);
        }
    }

    public static ProteinType pickRandom(DietPlan plan) {
        List<ProteinType> options = eligibleTypes(plan);

        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        ProteinType randomCarbType = options.get(randomIndex);
        
        return randomCarbType;
    }

    private static List<ProteinType> filterProteinOut(List<ProteinType> choices, Set<Tag> forbidden) {
        List<ProteinType> result = new ArrayList<>(choices.size());
        for (ProteinType type : choices) {
            Tag tag = proteinTagMap.get(type);
            if (!forbidden.contains(tag)) {
                result.add(type);
            }
        }
        return result;
    }

    @Override public String toString() { return "Protein: " + type; }

    @Override
    public void prepare() {
        
    }
}
