/**
 * BankAccount class represents a basic bank account with deposit and withdrawal functionality.
 * 
 * Exercise 1: Creating a Bank Account
 * - Attributes: accountNumber (String), balance (double)
 * - Methods: deposit(), withdraw()
 * - Demonstrates basic OOP concepts: encapsulation, class design
 */
public class BankAccount {
    
    // Attributes
    private String accountNumber;
    private double balance;
    
    /**
     * Constructor to initialize the account details.
     * 
     * @param accountNumber The unique account number (String)
     * @param initialBalance The initial balance of the account (double)
     */
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    /**
     * Deposits funds into the account.
     * Increases the balance by the amount specified.
     * 
     * @param amount The amount to deposit (must be positive)
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit: +" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount: " + amount);
        }
    }
    
    /**
     * Withdraws funds from the account.
     * Decreases the balance by the amount specified.
     * Only allows withdrawal if amount <= current balance.
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
}
