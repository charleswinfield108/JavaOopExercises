/**
 * CheckingAccount class extends BankAccount with overdraft protection.
 * 
 * Exercise 3: Creating a Checking Account
 * - Inherits from BankAccount
 * - Adds overdraftLimit field
 * - Overrides withdraw() to allow overdraft within the limit
 * - Demonstrates method overriding with enhanced validation
 */
public class CheckingAccount extends BankAccount {
    
    // Attribute
    private double overdraftLimit;
    
    /**
     * Constructor to initialize the checking account with overdraft limit.
     * 
     * @param accountNumber The unique account number (String)
     * @param initialBalance The initial balance of the account (double)
     * @param overdraftLimit The maximum overdraft protection allowed (double)
     */
    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    
    /**
     * Overridden withdraw method that allows overdraft protection.
     * Allows withdrawals up to balance + overdraftLimit.
     * Balance can go negative up to -overdraftLimit.
     * 
     * Formula: totalAvailable = balance + overdraftLimit
     * Allow withdrawal if: amount <= totalAvailable
     * 
     * @param amount The amount to withdraw (must be positive)
     */
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount: " + amount);
        } else {
            double currentBalance = getBalance();
            double totalAvailable = currentBalance + overdraftLimit;
            
            if (amount > totalAvailable) {
                // Withdrawal exceeds overdraft limit - REJECT
                System.out.println("Withdrawal denied. Exceeds overdraft limit.");
                System.out.println("  → Current Balance: $" + currentBalance);
                System.out.println("  → Overdraft Limit: $" + overdraftLimit);
                System.out.println("  → Total Available: $" + totalAvailable);
                System.out.println("  → Requested: $" + amount);
            } else {
                // Withdrawal is allowed - use protected setBalance to update balance
                double newBalance = currentBalance - amount;
                setBalance(newBalance);
                
                System.out.println("Withdrawal: -" + amount + " | New Balance: $" + newBalance);
                
                if (newBalance < 0) {
                    System.out.println("  → Account is now in overdraft: $" + Math.abs(newBalance));
                    System.out.println("  → Remaining overdraft protection: $" + (overdraftLimit + newBalance));
                }
            }
        }
    }
    
    /**
     * Gets the overdraft limit.
     * 
     * @return The overdraft limit
     */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
