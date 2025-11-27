package state;

import main.Snack;
import main.VendingMachine;

public class OutOfStockState implements State {

    private final VendingMachine vm;

    public OutOfStockState(VendingMachine vm) {
        this.vm = vm;
    }

    @Override
    public void selectSnack(String snackName) {
        Snack snack = vm.findSnack(snackName);
        if (snack != null && snack.getQuantity() > 0) {
            vm.setCurrentSnack(snack);
            vm.setState(vm.getWaitingForMoneyState());
            System.out.println("Selected " + snack.getName() + ". Please insert $" + snack.getPrice());
        } else {
            System.out.println("That snack is also out of stock. Please select another or cancel.");
        }
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Cannot insert money: selected snack is out of stock. Select another snack or cancel.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Cannot dispense: selected snack is out of stock.");
    }

    @Override
    public void cancel() {
        vm.returnMoney();
        vm.setCurrentSnack(null);
        vm.setState(vm.getIdleState());
        System.out.println("Cancelled. Returning to idle.");
    }
}
