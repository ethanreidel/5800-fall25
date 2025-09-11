package src.part2.core;

public class VendorInvoice implements Payable{
    private String vendor_name;
    private String invoice_number;
    private double amount_due;

    public VendorInvoice(String vendor_name, String invoice_number, double amount_due) {
        this.vendor_name = vendor_name;
        this.invoice_number = invoice_number;
        this.amount_due = amount_due;
    }

    public void set_vendor_name(String vendor_name) {this.vendor_name = vendor_name;}
    public void set_invoice_number(String invoice_number) {this.invoice_number = invoice_number;}
    public void set_amount_due(double amount_due) {
        if (amount_due < 0.0) {
            throw new IllegalArgumentException("Amount due must be non-negative");
        }
        this.amount_due = amount_due;
    }

    public String get_vendor_name() {return this.vendor_name;}
    public String get_invoice_number() {return this.invoice_number;}
    public double get_amount_due() {return this.amount_due;}

    public double calculatePayment() {
        return amount_due;
    }
    public String getPayeeName() {
        return vendor_name;
    }

    @Override
    public String toString() {
        return String.format("Vendor name: %s, invoice number: %s, calculated payment: $%.2f", vendor_name, invoice_number, calculatePayment());
    }
}
