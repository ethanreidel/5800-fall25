package test.bridge;
import bridge.*;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PaymentsImplementationTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream captured;

    @BeforeEach
    void setup() {
        originalOut = System.out;
        captured = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captured));
    }

    @AfterEach
    void teardown() {
        System.setOut(originalOut);
    }

    @Test
    void cash_email_100() {
        Payment p = new CashPayment(new EmailNotification(), 100);
        p.pay();
        String out = captured.toString();

        assertTrue(out.contains("EMAIL: "));
        assertTrue(out.contains("Amount due: $100.0 in cash"));
    }

    @Test
    void paypal_sms_1000() {
        Payment p = new PaypalPayment(new SMSNotification(), 1000);
        p.pay();
        String out = captured.toString();

        assertTrue(out.contains("SMS: "));
        assertTrue(out.contains("Amount due: $1000.0 in paypal balance"));
    }

    @Test
    void credit_sms_150() {
        Payment p = new CreditCardPayment(new SMSNotification(), 150);
        p.pay();
        String out = captured.toString();

        assertTrue(out.contains("SMS: "));
        assertTrue(out.contains("Amount due: $150.0 billed on your credit card"));
    }

    @Test
    void cash_sms_34() {
        Payment p = new CashPayment(new SMSNotification(), 34);
        p.pay();
        String out = captured.toString();

        assertTrue(out.contains("SMS: "));
        assertTrue(out.contains("Amount due: $34.0 in cash"));
    }

    @Test
    void bitcoin_email_1btc() {
        Payment p = new BitcoinPayment(new EmailNotification(), 1.0f);
        p.pay();
        String out = captured.toString();

        assertTrue(out.contains("EMAIL: "));
        assertTrue(out.contains("Amount due in BTC: 1.0"));
    }

    @Test
    void bitcoin_sms_halfbtc() {
        Payment p = new BitcoinPayment(new SMSNotification(), 0.5f);
        p.pay();
        String out = captured.toString();

        assertTrue(out.contains("SMS: "));
        assertTrue(out.contains("Amount due in BTC: 0.5"));
    }

    @Test
    void cash_push_20() {
        Payment p = new CashPayment(new PushNotification(), 20);
        p.pay();
        String out = captured.toString();

        assertTrue(out.contains("PUSH: "));
        assertTrue(out.contains("Amount due: $20.0 in cash"));
    }

    @Test
    void paypal_push_80() {
        Payment p = new PaypalPayment(new PushNotification(), 80);
        p.pay();
        String out = captured.toString();

        assertTrue(out.contains("PUSH: "));
        assertTrue(out.contains("Amount due: $80.0 in paypal balance"));
    }
}
