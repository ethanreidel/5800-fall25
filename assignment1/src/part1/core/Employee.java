package src.part1.core;

public class Employee {
    //private to ensure data is encapsulated, prevents data from being accessed outside the class willynilly
    private String first_name;
    private String last_name;
    private String social_security_number;

    public Employee(String fn, String ln, String SSN) { //looks like __init__ in python
        this.first_name = fn;
        this.last_name = ln;
        this.social_security_number = SSN; //this == self?
    }

    public void set_first_name(String first_name) {this.first_name = first_name;}
    public void set_last_name(String last_name) {this.last_name = last_name;}
    public void set_ssn(String social_securtity_number) {this.social_security_number = social_securtity_number;}

    public String get_first_name() { return first_name;}
    public String get_last_name() { return last_name;}
    public String get_ssn() { return social_security_number;}
}

