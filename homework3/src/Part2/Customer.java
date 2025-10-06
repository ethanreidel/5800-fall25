package Part2;

public class Customer {
    public String customerName;
    public DietPlan dietPlan;
    public Customer() {}
    public String getName() {
        return this.customerName;
    }
    public void setName(String customerName) {
        this.customerName = customerName;
    }
    public DietPlan getDietPlan() {
        return this.dietPlan;
    }
    public void setDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }

}
