package src.part1.core;

public class CommissionEmployee extends Employee {
    private double com_rate;
    private double gross_sales;

    public CommissionEmployee(double com_rate, double gross_sales,  String first_name, String last_name, String social_security_number) {
        super(first_name, last_name, social_security_number);
        this.com_rate = com_rate;
        this.gross_sales = gross_sales;
    }

    public void set_com_rate(int com_rate) {this.com_rate = com_rate;}
    public void set_gross_sales(int gross_sales) {this.gross_sales = gross_sales;}

    public double get_com_rate() {return this.com_rate;}
    public double get_gross_sales() {return this.gross_sales;}

    @Override
    public String toString() {
        return String.format("Commission Employee: %s %s. SSN: %s. Commission rate: %.2f%%, Gross sales: $%,.2f",
        get_first_name(), get_last_name(), get_ssn(), com_rate * 100, gross_sales);
    }
}
