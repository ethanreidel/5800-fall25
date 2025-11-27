package state;

public abstract interface State {
    void selectSnack(String snackName);
    void insertMoney(double amount);
    void dispenseSnack();
    void cancel();
}
