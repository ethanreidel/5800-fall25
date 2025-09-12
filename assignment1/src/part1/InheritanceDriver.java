package part1;
//javac file_name to compile and java file_name to execute

import part1.core.BaseEmployee;
import part1.core.CommissionEmployee;
import part1.core.HourlyEmployee;
import part1.core.SalariedEmployee;

//all classes that extend employee have first, last and ssn and their own individual vars outlined in the doc


public class InheritanceDriver //like main in python?
{


    public static void main(String[] args) {
        SalariedEmployee joe_jones = new SalariedEmployee(2500, "Joe", "Jones", "111-11-1111");
        HourlyEmployee stephanie_smith = new HourlyEmployee(25, 32, "Stephanie", "Smith", "222-22-2222");
        HourlyEmployee mary_quinn = new HourlyEmployee(19, 47, "Mary", "Quinn", "333-33-3333");
        CommissionEmployee nicole_dior = new CommissionEmployee(.15, 50000, "Nicole", "Dior", "444-44-4444");
        SalariedEmployee renwa_chanel = new SalariedEmployee(1700, "Renwa", "Chanel", "555-55-5555");
        BaseEmployee mike_davenport = new BaseEmployee(95000, "Mike", "Davenport", "666-66-6666");
        CommissionEmployee mahnaz_vaziri = new CommissionEmployee(.22, 40000, "Mahnaz", "Vaziri", "777-77-7777");

        System.out.println(joe_jones);
        System.out.println(stephanie_smith);
        System.out.println(mary_quinn);
        System.out.println(nicole_dior);
        System.out.println(renwa_chanel);
        System.out.println(mike_davenport);
        System.out.println(mahnaz_vaziri);

    }
    //anything run in here gets executed?    
}

