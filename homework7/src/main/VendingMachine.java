package main;

import chain.*;
import state.*;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private final Map<String, Snack> snacks = new HashMap<>();
    private Snack currentSnack;
    private double currentMoney = 0.0;

    private final State idleState;
    private final State waitingForMoneyState;
    private final State dispensingState;
    private final State outOfStockState;
    private State state;

    private SnackHandler snackChainHead;

    public VendingMachine() {
        idleState = new IdleState(this);
        waitingForMoneyState = new WaitingForMoneyState(this);
        dispensingState = new DispensingState(this);
        outOfStockState = new OutOfStockState(this);
        state = idleState;
    }

    public State getIdleState() { return idleState; }
    public State getWaitingForMoneyState() { return waitingForMoneyState; }
    public State getDispensingState() { return dispensingState; }
    public State getOutOfStockState() { return outOfStockState; }

    public void setState(State state) {
        this.state = state;
    }

    public void addSnack(Snack snack) {
        snacks.put(snack.getName().toLowerCase(), snack);
    }

    public Snack findSnack(String name) {
        return snacks.get(name.toLowerCase());
    }

    public Snack getCurrentSnack() {
        return currentSnack;
    }

    public void setCurrentSnack(Snack currentSnack) {
        this.currentSnack = currentSnack;
    }

    public double getCurrentMoney() {
        return currentMoney;
    }

    public void addMoney(double amount) {
        currentMoney += amount;
        System.out.printf("Machine balance: $%.2f%n", currentMoney);
    }

    public void resetMoney() {
        currentMoney = 0.0;
    }

    public void returnMoney() {
        if (currentMoney > 0) {
            System.out.printf("Returning $%.2f%n", currentMoney);
            currentMoney = 0.0;
        }
    }

    public void selectSnack(String snackName) {
        state.selectSnack(snackName);
    }

    public void insertMoney(double amount) {
        System.out.printf("Inserting $%.2f%n", amount);
        state.insertMoney(amount);
    }

    public void dispenseSnack() {
        state.dispenseSnack();
    }

    public void cancel() {
        state.cancel();
    }

    public void setSnackChainHead(SnackHandler handler) {
        this.snackChainHead = handler;
    }

    public boolean tryDispenseWithChain() {
        if (currentSnack == null) return false;

        boolean success = snackChainHead.handle(currentSnack, currentMoney);
        if (success) {
            currentMoney -= currentSnack.getPrice();
            System.out.printf("Change remaining: $%.2f%n", currentMoney);
            returnMoney();
            setCurrentSnack(null);
            setState(getIdleState());
        }
        return success;
    }
}
