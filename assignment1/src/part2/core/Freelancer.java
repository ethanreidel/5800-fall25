package part2.core;

public class Freelancer implements Payable{
    private String first_name;
    private String last_name;
    private double hourly_rate;
    private double hours_worked;

    public Freelancer(String first_name, String last_name, double hourly_rate, double hours_worked) {
        this.first_name = first_name;
        this.last_name = last_name;
        set_hourly_rate(hourly_rate);
        set_hours_worked(hours_worked);
    }

    public void set_first_name(String first_name) {this.first_name = first_name;}
    public void set_last_name(String last_name) {this.last_name = last_name;}
    public void set_hourly_rate(double hourly_rate) {
        if (hourly_rate < 0.0) {
            throw new IllegalArgumentException("Hourly rate must be >= 0.0");
        }
        this.hourly_rate = hourly_rate;
    }
    public void set_hours_worked(double hours_worked) {
        if (hours_worked < 0.0) {
            throw new IllegalArgumentException("Hours worked must be >= 0.0");
        }
        this.hours_worked = hours_worked;
    }

    public String get_first_name() {return this.first_name;}
    public String get_last_name() {return this.last_name;}
    public double get_hourly_rate() {return this.hourly_rate;}
    public double get_hours_worked() {return this.hours_worked;}

    public double calculatePayment() {
        //returns amount to be paid        
        if (hours_worked <= 40) {
            return hourly_rate * hours_worked;
        } else {
            double hours_over_40 = hours_worked - 40;
            return (hourly_rate * 40) + (1.5 * (hours_over_40 * hourly_rate));
        }
    }
    public String getPayeeName() {
        return first_name + " " + last_name;
    }

    @Override
    public String toString() {
        return String.format("Full name: %s %s, calculated payment: $%.2f", first_name, last_name, calculatePayment());
    }
}
