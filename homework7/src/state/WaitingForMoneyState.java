package state;

import main.VendingMachine;
import main.Snack;


public class WaitingForMoneyState implements State {
    private final VendingMachine vm;

    public WaitingForMoneyState(VendingMachine vm) {
        this.vm = vm;
    }

    @Override
    public void insertMoney(double amount) {
        vm.addMoney(amount);
        Snack snack = vm.getCurrentSnack();
        if (vm.getCurrentMoney() >= snack.getPrice()) {
            vm.setState(vm.getDispensingState());
            vm.dispenseSnack();
        } else {
            System.out.println("Inserted: $" + vm.getCurrentMoney() +
                               ", need: $" + snack.getPrice());
        }
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Already selected snack. Insert money or cancel.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Insert enough money first.");
    }

    @Override
    public void cancel() {
        vm.returnMoney();
        vm.setCurrentSnack(null);
        vm.setState(vm.getIdleState());
    }
}
