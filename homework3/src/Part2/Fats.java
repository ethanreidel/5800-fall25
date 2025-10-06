package Part2;

import java.util.*;

public class Fats implements Food{
    public enum FatsType {
        AVOCADO, SOUR_CREAM, TUNA, PEANUTS
    }

    private enum Tag {
        DAIRY, NUT, MEAT, NONE
    }

    private static final Map<FatsType, Tag> fatsTagMap = Map.of(
        FatsType.AVOCADO,       Tag.NONE,
        FatsType.SOUR_CREAM,    Tag.DAIRY,
        FatsType.TUNA,          Tag.MEAT,
        FatsType.PEANUTS,       Tag.NUT
    );

    private final FatsType type;

    public Fats(FatsType type) {
        this.type = type;
    }

    public static List<FatsType> eligibleTypes(DietPlan plan) {
            List<FatsType> all = Arrays.asList(FatsType.values());
            switch (plan) {
                case NO_RESTRICTION -> {
                    return all;
                }
                case PALEO -> {
                    return filterFatTypes(all, Set.of(Tag.DAIRY));
                }
                case VEGAN -> {
                    return filterFatTypes(all, Set.of(Tag.MEAT, Tag.DAIRY));
                }
                case NUT_ALLERGY -> {
                    return filterFatTypes(all, Set.of(Tag.NUT));
                }
                default -> throw new IllegalArgumentException("Unknown plan: " + plan);
            }
        }

    public static FatsType pickRandom(DietPlan plan) {
        List<FatsType> options = eligibleTypes(plan);

        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        FatsType randomCarbType = options.get(randomIndex);
        
        return randomCarbType;
    }

    private static List<FatsType> filterFatTypes(List<FatsType> choices, Set<Tag> forbidden) {
        List<FatsType> result = new ArrayList<>(choices.size());
        for (FatsType type : choices) {
            Tag tag = fatsTagMap.get(type);
            if (!forbidden.contains(tag)) {
                result.add(type);
            }
        }
        return result;
    }

    
    @Override public String toString() { return "Fat: " + type; }

    @Override
    public void prepare() {
        
    }
}
