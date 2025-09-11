package src.part4;

import java.util.ArrayList;

import src.part4.core.Course;
import src.part4.core.Instructor;
import src.part4.core.Textbook;

public class AggregationDriver {
    public static void main(String[] args) {
        Instructor Nima = new Instructor("Nima", "Davarpanah", "3-2636");
        Textbook Clean_Code = new Textbook("Clean Code", "Robert Cecil Martin", "Prentice Hall");
        Course CS5800 = new Course("5800", Nima, Clean_Code);

        Instructor Sai = new Instructor("Sai", "Kosaraju", "8-46");
        Textbook Computer_vision = new Textbook("Computer Vision: A Modern Approach", "D. Forsyth", "Prentice Hall");
        Course CS5190 = new Course("5190", Sai, Computer_vision);

        Instructor Algorithms_Professor = new Instructor("Algo", "Prof", "8-523");
        Textbook Advanced_Algos = new Textbook("Advanced Algorith Design", "Erik Demaine", "MIT");
        Course CS5300 = new Course("5300", Algorithms_Professor, Advanced_Algos);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(CS5800);
        courses.add(CS5190);
        courses.add(CS5300);

        for (Course course : courses) {
            System.out.println(course);
        }



    }
}
