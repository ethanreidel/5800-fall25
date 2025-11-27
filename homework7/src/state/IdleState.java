package state;

import main.Snack;
import main.VendingMachine;

public class IdleState implements State {
    private final VendingMachine vm;

    public IdleState(VendingMachine vm) {
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
            System.out.println("Snack not available.");
            vm.setState(vm.getOutOfStockState());
        }
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Select a snack first.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("No snack selected.");
    }

    @Override
    public void cancel() {
        // nothing to cancel in idle
    }
}
