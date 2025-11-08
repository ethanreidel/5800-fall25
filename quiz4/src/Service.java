package src;

public class Service {
    private PaymentProcess processor;

    public Service(PaymentProcess processor) {
        this.processor = processor;
    }

    public void perform_transaction(double amount) {
        processor.pay(amount);
        System.out.println("Transaction complete!\n");
    }
}
