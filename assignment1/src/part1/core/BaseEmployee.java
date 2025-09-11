package src.part1.core;

public class BaseEmployee extends Employee {
    private int base_salary;

    public BaseEmployee(int base_salary, String first_name, String last_name, String social_security_number) {
        super(first_name, last_name, social_security_number);
        this.base_salary = base_salary;
    }

    public void set_base_salary(int base_salary) {this.base_salary = base_salary;}

    public int get_base_salary() {return this.base_salary;}

    @Override
    public String toString() { //equivalent to repr in python
        return String.format("Base Employee: %s %s. SSN: %s. Base salary: $%d.",
        get_first_name(), get_last_name(), get_ssn(), base_salary);
    }
}
