/**
 * SavingsAccount class extends BankAccount with interest rate functionality.
 * 
 * Exercise 2: Creating a Savings Account
 * - Inherits from BankAccount
 * - Adds interestRate field
 * - Overrides deposit() to apply interest on deposits
 * - Demonstrates inheritance and method overriding
 */
public class SavingsAccount extends BankAccount {
    
    // Attribute
    private double interestRate;
    
    /**
     * Constructor to initialize the savings account with interest rate.
     * 
     * @param accountNumber The unique account number (String)
     * @param initialBalance The initial balance of the account (double)
     * @param interestRate The interest rate as a decimal (e.g., 0.05 for 5%)
     */
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }
    
    /**
     * Overridden deposit method that applies interest to deposits.
     * Increases the balance by the deposit amount plus the interest earned.
     * 
     * Formula: interest = amount * interestRate
     * Balance increase = amount + interest
     * 
     * @param amount The amount to deposit (must be positive)
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            double interest = amount * interestRate;
            double totalDeposit = amount + interest;
            double oldBalance = getBalance();
            
            // Call parent class deposit with total (amount + interest)
            super.deposit(totalDeposit);
            
            System.out.println("  → Deposit Amount: $" + amount);
            System.out.println("  → Interest Earned (" + (interestRate * 100) + "%): $" + interest);
            System.out.println("  → Total Added: $" + totalDeposit);
        } else {
            System.out.println("Invalid deposit amount: " + amount);
        }
    }
    
    /**
     * Gets the current interest rate.
     * 
     * @return The interest rate as a decimal
     */
    public double getInterestRate() {
        return interestRate;
    }
}
