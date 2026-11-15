package systemDesign.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// 1. Abstract Payment class
abstract class Payment {

    private final String reference;
    private final String method;
    private final double amount;

    protected Payment(String reference, String method, double amount) {
        this.reference = reference;
        this.method = method;
        this.amount = amount;
    }

    // Every payment type implements its own fee calculation
    public abstract double fee();

    // Common settlement logic
    public double settlement() {
        return amount - fee();
    }

    // Common receipt logic
    public String receipt() {
        return String.format(
                Locale.US,
                "%s (%s): charged $%.2f, fee $%.2f, settled $%.2f",
                reference,
                method,
                amount,
                fee(),
                settlement()
        );
    }

    protected double getAmount() {
        return amount;
    }
}

// 2. CardPayment class
class CardPayment extends Payment {

    private static final double FEE_RATE = 0.02;

    public CardPayment(String reference, double amount) {
        super(reference, "Card", amount);
    }

    @Override
    public double fee() {
        return getAmount() * FEE_RATE;
    }
}

// 3. UpiPayment class
class UpiPayment extends Payment {

    public UpiPayment(String reference, double amount) {
        super(reference, "UPI", amount);
    }

    @Override
    public double fee() {
        return 0.0;
    }
}

// 4. WalletPayment class
class WalletPayment extends Payment {

    private static final double FEE_RATE = 0.01;
    private static final double MAX_FEE = 10.0;

    public WalletPayment(String reference, double amount) {
        super(reference, "Wallet", amount);
    }

    @Override
    public double fee() {
        return Math.min(getAmount() * FEE_RATE, MAX_FEE);
    }
}

// 5. Provided PaymentGateway class
class PaymentGateway {

    private final List<Payment> payments = new ArrayList<>();

    public PaymentGateway() {
    }

    public int addCard(String reference, double amount) {
        payments.add(new CardPayment(reference, amount));
        return payments.size() - 1;
    }

    public int addUpi(String reference, double amount) {
        payments.add(new UpiPayment(reference, amount));
        return payments.size() - 1;
    }

    public int addWallet(String reference, double amount) {
        payments.add(new WalletPayment(reference, amount));
        return payments.size() - 1;
    }

    public double fee(int index) {
        return payments.get(index).fee();
    }

    public double settlement(int index) {
        return payments.get(index).settlement();
    }

    public String receipt(int index) {
        return payments.get(index).receipt();
    }

    public double totalFees() {
        double total = 0;

        for (Payment payment : payments) {
            total += payment.fee();
        }

        return total;
    }

    public static void main(String[] args) {

        PaymentGateway gateway = new PaymentGateway();

        // Add payments
        int cardIndex = gateway.addCard("TXN101", 1000);
        int upiIndex = gateway.addUpi("TXN102", 500);
        int walletIndex = gateway.addWallet("TXN103", 2000);

        // Card payment
        System.out.println("Card Payment:");
        System.out.println("Fee: " + gateway.fee(cardIndex));
        System.out.println("Settlement: " + gateway.settlement(cardIndex));
        System.out.println(gateway.receipt(cardIndex));

        System.out.println();

        // UPI payment
        System.out.println("UPI Payment:");
        System.out.println("Fee: " + gateway.fee(upiIndex));
        System.out.println("Settlement: " + gateway.settlement(upiIndex));
        System.out.println(gateway.receipt(upiIndex));

        System.out.println();

        // Wallet payment
        System.out.println("Wallet Payment:");
        System.out.println("Fee: " + gateway.fee(walletIndex));
        System.out.println("Settlement: " + gateway.settlement(walletIndex));
        System.out.println(gateway.receipt(walletIndex));

        System.out.println();

        // Total fees
        System.out.println("Total Fees: " + gateway.totalFees());
    }
}
