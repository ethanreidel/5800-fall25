package Part2;

import java.util.*;

public class Carbs implements Food {
    public enum CarbType {
        CHEESE, BREAD, LENTILS, PISTACHIO
    }

    private enum Tag {
        DAIRY, NUT, NONE
    }

    private static final Map<CarbType, Tag> carbTagMap = Map.of(
        CarbType.CHEESE,    Tag.DAIRY,
        CarbType.BREAD,     Tag.NONE,
        CarbType.LENTILS,   Tag.NONE,
        CarbType.PISTACHIO, Tag.NUT
    );


    private final CarbType type;

    public Carbs(CarbType type) {
        this.type = type;
    } 

    public static List<CarbType> eligibleTypes(DietPlan plan) {
        List<CarbType> all = Arrays.asList(CarbType.values());
        switch(plan) {
            case NO_RESTRICTION -> {
                return all;
            }
            case PALEO -> {
                return List.of(CarbType.PISTACHIO);
            }
            case VEGAN -> {
                return filterCarbTypes(all, Set.of(Tag.DAIRY));
            }
            case NUT_ALLERGY -> {
                return filterCarbTypes(all, Set.of(Tag.NUT));
            }
            default -> throw new IllegalArgumentException("Unknown plan: " + plan);
        }
    }

    public static CarbType pickRandom(DietPlan plan) {
        List<CarbType> options = eligibleTypes(plan);

        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        CarbType randomCarbType = options.get(randomIndex);

        return randomCarbType;
    }

    private static List<CarbType> filterCarbTypes(List<CarbType> choices, Set<Tag> forbidden) {
        List<CarbType> result = new ArrayList<>(choices.size());
        for (CarbType type : choices) {
            Tag tag = carbTagMap.get(type);
            if (!forbidden.contains(tag)) {
                result.add(type);
            }
        }
        return result;
    }

    @Override public String toString() { return "Carb: " + type; }

    @Override
    public void prepare() {
        System.out.println("Carb plan");
    }
}
