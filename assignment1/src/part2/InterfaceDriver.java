package src.part2;

import java.util.ArrayList;
//driver program

import src.part2.core.Freelancer;
import src.part2.core.Payable;
import src.part2.core.VendorInvoice;

public class InterfaceDriver {
    public static void main(String[] args) {
        Freelancer ethan = new Freelancer("Ethan", "reidel", 40.5, 60);

        VendorInvoice jonah = new VendorInvoice("Jonah", "1234-66-7342", 5000);

        Freelancer roger = new Freelancer("Roger", "Federer", 60, 70);

        VendorInvoice rafa = new VendorInvoice("Rafael", "7232-62-2325", 10000);

        //all objects are allocd on the heap, primitives allocd on the stack
        ArrayList<Payable> payables = new ArrayList<>();
        payables.add(ethan);
        payables.add(jonah);
        payables.add(roger);
        payables.add(rafa);

        double total_payout = 0;

        for (Payable person : payables) {
            System.out.println(person);
            total_payout += person.calculatePayment();
        }
        System.out.println("Total payout: $" + total_payout);

    }

    

}
