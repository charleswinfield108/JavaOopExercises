import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer class represents a customer who manages multiple bank accounts.
 * 
 * Exercise 4: Managing Customer's Accounts
 * - Maintains customer name and collection of accounts
 * - Allows adding accounts to customer
 * - Calculates total balance across all accounts
 * - Demonstrates composition and collection management
 */
public class BankCustomer {
    
    // Attributes
    private String name;
    private List<BankAccount> accounts;
    
    /**
     * Constructor to initialize the customer with a name and empty accounts collection.
     * 
     * @param name The customer's name (String)
     */
    public BankCustomer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }
    
    /**
     * Adds a bank account to the customer's accounts collection.
     * 
     * @param account The BankAccount object to add (can be BankAccount, SavingsAccount, or CheckingAccount)
     */
    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Added account " + account.getAccountNumber() + " for customer " + name);
    }
    
    /**
     * Calculates the total balance across all accounts.
     * Sums balances from all account types, including overdrafts (negative balances).
     * 
     * Formula: totalBalance = sum of (balance for each account in accounts)
     * 
     * @return The total combined balance of all accounts
     */
    public double totalBalance() {
        double total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
    
    /**
     * Gets the customer's name.
     * 
     * @return The customer's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the customer's accounts collection.
     * 
     * @return List of BankAccount objects
     */
    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
