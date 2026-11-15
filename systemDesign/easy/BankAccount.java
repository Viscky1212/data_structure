package systemDesign.easy;

import java.util.Locale;

class BankAccount {

    // Private fields: Encapsulation
    private final String accountNumber;
    private final String ownerName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        // Validate amount and available balance
        if (amount <= 0 || balance < amount) {
            return false;
        }

        balance -= amount;
        return true;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Return account summary
    public String getSummary() {
        return String.format(
                Locale.US,
                "%s (%s) | Balance: $%.2f",
                ownerName,
                accountNumber,
                balance
        );
    }

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount("ACC-123", "John Doe");

        // Initial balance
        System.out.println(account.getBalance());

        // Deposit
        System.out.println(account.deposit(1000));
        System.out.println(account.getBalance());

        // Withdraw
        System.out.println(account.withdraw(500));
        System.out.println(account.getBalance());

        // Insufficient balance
        System.out.println(account.withdraw(1000));
        System.out.println(account.getBalance());

        // Invalid deposit
        System.out.println(account.deposit(-100));

        // Invalid withdrawal
        System.out.println(account.withdraw(0));

        // Account summary
        System.out.println(account.getSummary());
    }


}

