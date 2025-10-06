package Part2;

public final class DefaultMacronutrientFactory implements MacronutrientFactory {
    private static final DefaultMacronutrientFactory instance = new DefaultMacronutrientFactory();

    private final CarbFactory carbFactory = CarbFactory.getInstance();
    private final ProteinFactory proteinFactory = ProteinFactory.getInstance();
    private final FatsFactory fatsFactory = FatsFactory.getInstance();

    private DefaultMacronutrientFactory() {}

    public static DefaultMacronutrientFactory getInstance() {
        return instance;
    }

    @Override public Carbs createCarb(DietPlan plan) {
        return carbFactory.create(plan); 
    }
    @Override public Protein createProtein(DietPlan plan) { 
        return proteinFactory.create(plan); 
    }
    @Override public Fats createFat(DietPlan plan) { 
        return fatsFactory.create(plan); 
    }
}