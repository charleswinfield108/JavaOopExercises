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
        BankAccount account1 = new BankAccount("ACC001", 1000);
        System.out.println("Account: " + account1.getAccountNumber() + " | Initial Balance: $" + account1.getBalance());
        
        account1.deposit(500);    // Valid deposit
        account1.withdraw(200);   // Valid withdrawal
        account1.withdraw(2000);  // Invalid withdrawal (exceeds balance)
        
        System.out.println("Final Balance: $" + account1.getBalance());

        // Exercise 2: Creating a Savings Account
        // Create a SavingsAccount instance
        // Perform deposit operations with interest

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