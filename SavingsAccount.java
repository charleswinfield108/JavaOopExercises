public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double newRate) {
        this.interestRate = newRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            // First deposit the amount
            super.deposit(amount);
            // Then calculate and add interest on the deposited amount
            double interest = amount * interestRate;
            System.out.println("Interest earned: " + interest);
            // Add interest to balance by calling parent's logic
            super.deposit(interest);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", interestRate=" + (interestRate * 100) + "%" +
                '}';
    }
}
