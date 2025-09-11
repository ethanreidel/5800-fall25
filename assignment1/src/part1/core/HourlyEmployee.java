package src.part1.core;

public class HourlyEmployee extends Employee{
    private int wage;
    private int hours_worked;

    public HourlyEmployee(int wage, int hours_worked, String first_name, String last_name, String social_security_number) {
        super(first_name, last_name, social_security_number);
        this.wage = wage;
        this.hours_worked = hours_worked;
    }

    public void set_wage(int wage) {this.wage = wage;}
    public void set_hours_worked(int hours_worked) {this.hours_worked = hours_worked;}

    public int get_wage() {return this.wage;}
    public int get_hours_worked() {return this.hours_worked;}

    @Override
    public String toString() {
        return String.format("Hourly Employee: %s %s. SSN: %s. Wage: $%d. Number of hours worked: %s",
        get_first_name(), get_last_name(), get_ssn(), wage, hours_worked);
    }
}
