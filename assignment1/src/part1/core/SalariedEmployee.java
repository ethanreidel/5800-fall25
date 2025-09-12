package part1.core;

public class SalariedEmployee extends Employee {
    private int weekly_salary;
    
    public SalariedEmployee(int weekly_salary, String first_name, String last_name, String social_security_number) {
        super(first_name, last_name, social_security_number);
        this.weekly_salary = weekly_salary;
    }
    
    public void set_weekly_salary(int weekly_salary) {this.weekly_salary = weekly_salary;}

    public int get_weekly_salary() {return this.weekly_salary;};

    @Override 
    public String toString() {
        return String.format("Salaried Employee: %s %s. SSN: %s. Weekly Salary: $%d", 
                         get_first_name(), get_last_name(), get_ssn(), weekly_salary);
    }
    
    
}
