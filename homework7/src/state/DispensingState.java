package state;

import main.VendingMachine;

public class DispensingState implements State {
    private final VendingMachine vm;

    public DispensingState(VendingMachine vm) {
        this.vm = vm;
    }

    @Override
    public void dispenseSnack() {
        boolean ok = vm.tryDispenseWithChain();
        if (!ok) {
            System.out.println("Unable to dispense snack.");
            vm.setState(vm.getIdleState());
        }
    }

    @Override public void selectSnack(String snackName) {}
    @Override public void insertMoney(double amount) {}
    @Override public void cancel() {}
}
