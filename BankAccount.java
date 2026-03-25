import java.util.ArrayList;
import java.util.List;

/**
 * BankAccount class represents a basic bank account with deposit and withdrawal functionality.
 * 
 * Exercise 1: Creating a Bank Account
 * Exercise 5: Extended with Transaction History tracking
 * - Attributes: accountNumber (String), balance (double), transactions (List<String>)
 * - Methods: deposit(), withdraw(), recordTransaction(), getTransactionHistory()
 * - Demonstrates basic OOP concepts: encapsulation, class design
 * - Demonstrates collection management and audit logging
 */
public class BankAccount {
    
    // Attributes
    private String accountNumber;
    private double balance;
    private List<String> transactions;
    
    /**
     * Constructor to initialize the account details.
     * 
     * @param accountNumber The unique account number (String)
     * @param initialBalance The initial balance of the account (double)
     */
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();  // Initialize empty transaction history
    }
    
    /**
     * Deposits funds into the account.
     * Increases the balance by the amount specified.
     * Records the transaction in the transaction history.
     * 
     * @param amount The amount to deposit (must be positive)
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposit: +" + amount);
            System.out.println("Deposit: +" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount: " + amount);
        }
    }
    
    /**
     * Withdraws funds from the account.
     * Decreases the balance by the amount specified.
     * Only allows withdrawal if amount <= current balance.
     * Records successful transactions in the transaction history.
     * Invalid withdrawals are NOT recorded.
     * 
     * @param amount The amount to withdraw (must be positive and <= balance)
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount: " + amount);
        } else if (amount > balance) {
            System.out.println("Withdrawal denied. Insufficient funds. Balance: $" + balance + ", Requested: $" + amount);
        } else {
            balance -= amount;
            recordTransaction("Withdraw: -" + amount);
            System.out.println("Withdrawal: -" + amount + " | New Balance: $" + balance);
        }
    }
    
    /**
     * Gets the current balance of the account.
     * 
     * @return The current balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Gets the account number.
     * 
     * @return The account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Protected helper method to update balance directly.
     * Used by subclasses that need custom withdrawal/deposit logic (e.g., overdraft protection).
     * 
     * @param newBalance The new balance to set
     */
    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }
    
    /**
     * Override toString() to display account information in readable format.
     * Used by generateReport() and System.out.println().
     * 
     * @return String representation of account
     */
    @Override
    public String toString() {
        return "BankAccount{accountNumber='" + accountNumber + "', balance=$" + balance + "}";
    }
    
    /**
     * Records a transaction to the transaction history.
     * This is a private method called internally after successful transactions.
     * 
     * @param transaction The transaction description to record
     */
    private void recordTransaction(String transaction) {
        transactions.add(transaction);
    }
    
    /**
     * Gets the complete transaction history for this account.
     * Returns all recorded deposits and withdrawals in order they occurred.
     * 
     * @return List of transaction strings in chronological order
     */
    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactions);  // Return a copy to protect the original list
    }
}
