package part4.core;

public class Instructor {
    private String first_name;
    private String last_name;
    private String office_number;

    public Instructor(String first_name, String last_name, String office_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.office_number = office_number;
    }

    public void set_first_name(String first_name) {this.first_name = first_name;}
    public void set_last_name(String last_name) {this.last_name = last_name;}
    public void set_office_number(String office_number) {this.office_number = office_number;}

    public String get_first_name() {return this.first_name;}
    public String get_last_name() {return this.last_name;}
    public String get_office_number() {return this.office_number;}


}
