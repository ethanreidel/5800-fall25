package test;

import main.Snack;
import main.VendingMachine;
import chain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    private VendingMachine vm;

    @BeforeEach
    void setUp() {
        vm = new VendingMachine();

        Snack coke     = new Snack("Coke",     1.50, 5);
        Snack pepsi    = new Snack("Pepsi",    1.50, 5);
        Snack cheetos  = new Snack("Cheetos",  2.00, 3);
        Snack doritos  = new Snack("Doritos",  2.00, 3);
        Snack kitkat   = new Snack("KitKat",   1.25, 4);
        Snack snickers = new Snack("Snickers", 1.25, 2);

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
    }

    @Test
    void dispensesSnackWhenEnoughMoneyAndInStock() {
        Snack coke = vm.findSnack("Coke");
        int initialQty = coke.getQuantity();

        vm.selectSnack("Coke");
        vm.insertMoney(2.00);

        int finalQty = vm.findSnack("Coke").getQuantity();
        assertEquals(initialQty - 1, finalQty,
                "Coke quantity should decrease by 1 when enough money is inserted");
    }

    @Test
    void doesNotDispenseWhenInsufficientMoney() {
        Snack pepsi = vm.findSnack("Pepsi");
        int initialQty = pepsi.getQuantity();

        vm.selectSnack("Pepsi");
        vm.insertMoney(0.50);

        int finalQty = vm.findSnack("Pepsi").getQuantity();
        assertEquals(initialQty, finalQty,
                "Pepsi quantity should not change when insufficient money is inserted");
    }

    @Test
    void snickersQuantityHitsZeroAndCannotDispenseMore() {
        Snack snickers = vm.findSnack("Snickers");
        assertEquals(2, snickers.getQuantity(), "Precondition: Snickers quantity should start at 2");


        vm.selectSnack("Snickers");
        vm.insertMoney(2.00);
        assertEquals(1, snickers.getQuantity(),
                "After first purchase, Snickers quantity should be 1");


        vm.selectSnack("Snickers");
        vm.insertMoney(2.00);
        assertEquals(0, snickers.getQuantity(),
                "After second purchase, Snickers quantity should be 0");

        vm.selectSnack("Snickers");
        vm.insertMoney(2.00);

        assertEquals(0, snickers.getQuantity(),
                "Snickers quantity should stay at 0 when out of stock and another purchase is attempted");
    }

    @Test
    void chainOnlyDispensesSelectedSnackType() {
        Snack kitkat  = vm.findSnack("KitKat");
        Snack coke    = vm.findSnack("Coke");
        Snack pepsi   = vm.findSnack("Pepsi");
        Snack cheetos = vm.findSnack("Cheetos");
        Snack doritos = vm.findSnack("Doritos");
        Snack snickers= vm.findSnack("Snickers");

        int kitkatInitial   = kitkat.getQuantity();
        int cokeInitial     = coke.getQuantity();
        int pepsiInitial    = pepsi.getQuantity();
        int cheetosInitial  = cheetos.getQuantity();
        int doritosInitial  = doritos.getQuantity();
        int snickersInitial = snickers.getQuantity();

        vm.selectSnack("KitKat");
        vm.insertMoney(2.00);

        assertEquals(kitkatInitial - 1, kitkat.getQuantity(),
                "KitKat quantity should decrease by 1 after purchase");

        assertEquals(cokeInitial, coke.getQuantity(), "Coke quantity should be unchanged");
        assertEquals(pepsiInitial, pepsi.getQuantity(), "Pepsi quantity should be unchanged");
        assertEquals(cheetosInitial, cheetos.getQuantity(), "Cheetos quantity should be unchanged");
        assertEquals(doritosInitial, doritos.getQuantity(), "Doritos quantity should be unchanged");
        assertEquals(snickersInitial, snickers.getQuantity(), "Snickers quantity should be unchanged");
    }
}
