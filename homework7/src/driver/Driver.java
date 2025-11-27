package driver;

import main.*;
import chain.*;

public class Driver {

    public static void main(String[] args) {

        VendingMachine vm = new VendingMachine();

        Snack coke    = new Snack("Coke",    1.50, 5);
        Snack pepsi   = new Snack("Pepsi",   1.50, 5);
        Snack cheetos = new Snack("Cheetos", 2.00, 3);
        Snack doritos = new Snack("Doritos", 2.00, 3);
        Snack kitkat  = new Snack("KitKat",  1.25, 4);
        Snack snickers= new Snack("Snickers",1.25, 2);

        vm.addSnack(coke);
        vm.addSnack(pepsi);
        vm.addSnack(cheetos);
        vm.addSnack(doritos);
        vm.addSnack(kitkat);
        vm.addSnack(snickers);

        SnackHandler cokeH     = new CokeHandler(coke);
        SnackHandler pepsiH    = new PepsiHandler(pepsi);
        SnackHandler cheetosH  = new CheetosHandler(cheetos);
        SnackHandler doritosH  = new DoritosHandler(doritos);
        SnackHandler kitkatH   = new KitKatHandler(kitkat);
        SnackHandler snickersH = new SnickersHandler(snickers);

        cokeH.setNextHandler(pepsiH)
             .setNextHandler(cheetosH)
             .setNextHandler(doritosH)
             .setNextHandler(kitkatH)
             .setNextHandler(snickersH);

        vm.setSnackChainHead(cokeH);

        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.println("\nAttempt " + attempt + " to buy Snickers");

            vm.selectSnack("Snickers");


            vm.insertMoney(2.00);


            System.out.println("Snickers quantity after attempt " + attempt + ": "
                    + vm.findSnack("Snickers").getQuantity());
        }

        System.out.println("\nFinal Snickers quantity: "
                + vm.findSnack("Snickers").getQuantity());
    }
}
