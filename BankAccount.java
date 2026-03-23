import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private List<String> transactions;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        recordTransaction("Account opened with initial balance: $" + initialBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposit: $" + amount + ". New Balance: $" + balance);
            System.out.println("Deposited: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recordTransaction("Withdrawal: $" + amount + ". New Balance: $" + balance);
            System.out.println("Withdrew: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Withdrawal amount must be positive and less than or equal to the current balance.");
        }
    }

    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public void recordTransaction(String transaction) {
        transactions.add(transaction);
    }

    public void getTransactionHistory() {
        System.out.println("\nTransaction History for Account " + accountNumber + ":");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + ". " + transactions.get(i));
        }
    }

    public List<String> getTransactions() {
        return transactions;
    }
}