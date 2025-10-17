package decorator;



public class Loyalty implements LoyaltyPolicy {
    private final LoyaltyTier tier;
    private final double bronzePercent;
    private final double silverPercent;
    private final double goldPercent;

    public Loyalty(LoyaltyTier tier, double bronzePercent, double silverPercent, double goldPercent) {
        this.tier = tier;
        this.bronzePercent = bronzePercent;
        this.silverPercent = silverPercent;
        this.goldPercent = goldPercent;
    }

    @Override
    public double apply(double subtotal) {
        double rate = switch (tier) {
            case BRONZE -> bronzePercent;
            case SILVER -> silverPercent;
            case GOLD -> goldPercent;
        };
        double discount = subtotal * rate;
        double finalCost = subtotal - discount;
        return finalCost;
    }

}
