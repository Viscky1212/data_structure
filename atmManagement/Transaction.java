package atmManagement;

public class Transaction {
    private String type;
    private long amount;
    private long balance;

    public Transaction(String type, long amount, long balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public long getAmount() {
        return amount;
    }

    public long getBalance() {
        return balance;
    }
}
