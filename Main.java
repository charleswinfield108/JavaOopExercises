public class Main {
    public static void main(String[] args) {

        // Exercise 0: Using the Example Person Class
        // Create an instance of Person
        // Use the instance to print "Hello, my name is [name] and I'm [age] years old."
        Person person = new Person("Simon", 24);
        System.out.println("Hello, my name is " + person.getName() + " and I'm " + person.getAge() + " years old.");

        // Exercise 1: Creating a Bank Account
        // Create a BankAccount instance
        // Perform deposit and withdrawal operations.
        System.out.println("\n--- Exercise 1: Bank Account ---");
        BankAccount account = new BankAccount("ACC001", 1000.0);
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Initial Balance: $" + account.getBalance());
        
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(2000); // Attempt to withdraw more than balance

        // Exercise 2: Creating a Savings Account
        // Create a SavingsAccount instance
        // Perform deposit operations with interest
        System.out.println("\n--- Exercise 2: Savings Account ---");
        SavingsAccount savingsAccount = new SavingsAccount("SAV001", 1000.0, 0.05);
        System.out.println("Savings Account Number: " + savingsAccount.getAccountNumber());
        System.out.println("Initial Balance: $" + savingsAccount.getBalance());
        System.out.println("Interest Rate: " + (savingsAccount.getInterestRate() * 100) + "%");
        
        System.out.println("\nDepositing $500 with 5% interest:");
        savingsAccount.deposit(500);
        savingsAccount.deposit(2500);

        // Exercise 3: Creating a Checking Account
        // Create a CheckingAccount instance
        // Perform withdrawal operations with overdraft
        System.out.println("\n--- Exercise 3: Checking Account ---");
        CheckingAccount checkingAccount = new CheckingAccount("CHK001", 500.0, 200.0);
        System.out.println("Checking Account Number: " + checkingAccount.getAccountNumber());
        System.out.println("Initial Balance: $" + checkingAccount.getBalance());
        System.out.println("Overdraft Limit: $" + checkingAccount.getOverdraftLimit());
        
        System.out.println("\nWithdrawing $600 (exceeds balance, uses overdraft):");
        checkingAccount.withdraw(600);
        
        System.out.println("\nWithdrawing $50 (within remaining overdraft):");
        checkingAccount.withdraw(50);
        
        System.out.println("\nAttempting to withdraw $200 (exceeds overdraft limit):");
        checkingAccount.withdraw(200);

        // Exercise 4: Managing Customer's Accounts
        // Create a BankCustomer instance
        // Add multiple accounts and display total balance
        System.out.println("\n--- Exercise 4: Managing Customer's Accounts ---");
        BankCustomer customer = new BankCustomer("John Doe");
        System.out.println("Customer: " + customer.getName());
        
        // Create multiple accounts
        BankAccount acc1 = new BankAccount("ACC002", 2000.0);
        SavingsAccount acc2 = new SavingsAccount("SAV002", 3000.0, 0.03);
        CheckingAccount acc3 = new CheckingAccount("CHK002", 1500.0, 300.0);
        
        // Add accounts to customer
        customer.addAccount(acc1);
        customer.addAccount(acc2);
        customer.addAccount(acc3);
        
        // Display all accounts and total balance
        customer.displayAccounts();

        // Exercise 5: Transaction History
        // Add transactions to accounts and retrieve history
        System.out.println("\n--- Exercise 5: Transaction History ---");
        BankAccount transAccount = new BankAccount("TX001", 1000.0);
        
        transAccount.deposit(500);
        transAccount.withdraw(200);
        transAccount.deposit(300);
        transAccount.withdraw(100);
        
        transAccount.getTransactionHistory();

        // Exercise 6: Generate Banking Report
        // Generate and display a customer's banking report
        System.out.println("\n--- Exercise 6: Generate Banking Report ---");
        BankCustomer reportCustomer = new BankCustomer("Jane Smith");
        reportCustomer.addAccount(new BankAccount("ACC003", 5000.0));
        reportCustomer.addAccount(new SavingsAccount("SAV003", 8000.0, 0.04));
        reportCustomer.addAccount(new CheckingAccount("CHK003", 2000.0, 500.0));
        
        reportCustomer.generateReport();

        // Exercise 7: Update Interest Rates
        // Update the interest rate and observe calculations
        System.out.println("\n--- Exercise 7: Update Interest Rates ---");
        SavingsAccount rateAccount = new SavingsAccount("SAV004", 1000.0, 0.02);
        System.out.println("Initial Interest Rate: " + (rateAccount.getInterestRate() * 100) + "%");
        System.out.println("Depositing $1000:");
        rateAccount.deposit(1000);
        
        System.out.println("\nUpdating interest rate to 5%:");
        rateAccount.setInterestRate(0.05);
        System.out.println("New Interest Rate: " + (rateAccount.getInterestRate() * 100) + "%");
        System.out.println("Depositing $500 with new rate:");
        rateAccount.deposit(500);

        // Exercise 8: Override Withdrawal Method
        // Demonstrate overridden withdrawal method
        System.out.println("\n--- Exercise 8: Override Withdrawal Method ---");
        CheckingAccount overdraftAccount = new CheckingAccount("CHK004", 300.0, 200.0);
        System.out.println("Checking Account Balance: $" + overdraftAccount.getBalance());
        System.out.println("Overdraft Limit: $" + overdraftAccount.getOverdraftLimit());
        System.out.println("Total Available: $" + (overdraftAccount.getBalance() + overdraftAccount.getOverdraftLimit()));
        
        System.out.println("\nAttempting to withdraw $400 (within balance + overdraft):");
        overdraftAccount.withdraw(400);
        System.out.println("New Balance: $" + overdraftAccount.getBalance());
        
        System.out.println("\nAttempting to withdraw $150 (within remaining overdraft):");
        overdraftAccount.withdraw(150);
        System.out.println("New Balance: $" + overdraftAccount.getBalance());
        
        System.out.println("\nAttempting to withdraw $300 (exceeds total available):");
        overdraftAccount.withdraw(300);
        System.out.println("Final Balance: $" + overdraftAccount.getBalance());

        // Complete all exercises and print results
    }
}