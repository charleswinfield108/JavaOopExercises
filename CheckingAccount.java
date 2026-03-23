public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double newLimit) {
        this.overdraftLimit = newLimit;
    }

    @Override
    public void withdraw(double amount) {
        double totalAvailable = getBalance() + overdraftLimit;

        if (amount > 0 && amount <= totalAvailable) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            
            if (newBalance < 0) {
                System.out.println("Withdrew: " + amount + ". Using overdraft. New Balance: " + newBalance);
            } else {
                System.out.println("Withdrew: " + amount + ". New Balance: " + newBalance);
            }
        } else {
            System.out.println("Withdrawal amount exceeds available balance (" + getBalance() + 
                             ") and overdraft limit (" + overdraftLimit + ").");
        }
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}
