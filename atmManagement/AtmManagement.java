package atmManagement;

import java.util.List;

class User {
    private String name;
    private int balance;
    private int accountNumber;
    private int pin;

    //List of transactions
    private List<Transaction> transactions;


    public User(String name, int balance, int accountNumber, int pin) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pin = pin;

    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

public class AtmManagement {

    //design basic ATM system with user registration, login, check balance, deposit and withdraw amount, maintain transaction history
    //implement the ATM logic here
    //create user, check balance, deposit and withdraw amount, maintain transaction history

    //create user





    public static void main(String[] args) {

        //create user
        User user = new User("John", 1000, 123456, 1234);

        //check balance
        System.out.println("Balance: " + user.getBalance());

        //deposit amount
        user.setBalance(user.getBalance() + 500);
        System.out.println("Balance after deposit: " + user.getBalance());

        //withdraw amount
        user.setBalance(user.getBalance() - 200);
        System.out.println("Balance after withdraw: " + user.getBalance());
    }

}
