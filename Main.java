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

        // Exercise 4: Managing Customer's Accounts
        // Create a BankCustomer instance
        // Add multiple accounts and display total balance

        // Exercise 5: Transaction History
        // Add transactions to accounts and retrieve history

        // Exercise 6: Generate Banking Report
        // Generate and display a customer's banking report

        // Exercise 7: Update Interest Rates
        // Update the interest rate and observe calculations

        // Exercise 8: Override Withdrawal Method
        // Demonstrate overridden withdrawal method

        // Complete all exercises and print results
    }
}