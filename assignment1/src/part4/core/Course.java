package part4.core;

public class Course {
    private String name;
    private Instructor instructor;
    private Textbook txtbook;

    public Course(String name, Instructor instructor, Textbook txtbook) {
        this.name = name;
        this.instructor = instructor;
        this.txtbook = txtbook;
    }

    public void set_name(String name) {this.name = name;}
    public void set_instructor(Instructor instructor) {this.instructor=instructor;}
    public void set_textbook(Textbook txtbook) {this.txtbook = txtbook;}

    public String get_name() {return this.name;}
    public Instructor get_instructor() {return this.instructor;}
    public Textbook get_textbook() {return this.txtbook;}

    @Override
    public String toString() {
        //edit this when other infra ios done
        return String.format("Course name: %s, Instructor name: %s %s, Textbook title: %s, Textbook author: %s, Textbook publisher: %s",
        name, this.instructor.get_first_name(), this.instructor.get_last_name(), this.txtbook.get_title(), this.txtbook.get_author(), this.txtbook.get_publisher());
    }
}
