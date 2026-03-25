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
        System.out.println("\n--- Exercise 2: Savings Account ---");
        SavingsAccount savingsAccount = new SavingsAccount("SAV001", 1000, 0.05);
        System.out.println("Account: " + savingsAccount.getAccountNumber() + " | Initial Balance: $" + savingsAccount.getBalance() + " | Interest Rate: 5%");
        
        System.out.println("\nDeposit #1: $100");
        savingsAccount.deposit(100);  // $100 deposit + 5% interest = $105 added
        System.out.println("Balance after deposit: $" + savingsAccount.getBalance());
        
        System.out.println("\nDeposit #2: $200");
        savingsAccount.deposit(200);  // $200 deposit + 5% interest = $210 added
        System.out.println("Balance after deposit: $" + savingsAccount.getBalance());

        // Exercise 3: Creating a Checking Account
        // Create a CheckingAccount instance
        // Perform withdrawal operations with overdraft
        System.out.println("\n--- Exercise 3: Checking Account ---");
        CheckingAccount checkingAccount = new CheckingAccount("CHK001", 500, 200);
        System.out.println("Account: " + checkingAccount.getAccountNumber() + " | Initial Balance: $" + checkingAccount.getBalance() + " | Overdraft Limit: $" + checkingAccount.getOverdraftLimit());
        System.out.println("Total Available (Balance + Overdraft): $" + (checkingAccount.getBalance() + checkingAccount.getOverdraftLimit()));
        
        System.out.println("\nWithdrawal #1: $300 (within balance)");
        checkingAccount.withdraw(300);  // $500 - $300 = $200 (within balance)
        System.out.println("Balance after withdrawal: $" + checkingAccount.getBalance());
        
        System.out.println("\nWithdrawal #2: $250 (uses overdraft)");
        checkingAccount.withdraw(250);  // $200 - $250 = -$50 (uses overdraft protection)
        System.out.println("Balance after withdrawal: $" + checkingAccount.getBalance());
        
        System.out.println("\nWithdrawal #3: $200 (exceeds overdraft limit)");
        checkingAccount.withdraw(200);  // Would be -$250, exceeds -$200 limit, REJECTED
        System.out.println("Balance after withdrawal attempt: $" + checkingAccount.getBalance());

        // Exercise 4: Managing Customer's Accounts
        // Create a BankCustomer instance
        // Add multiple accounts and display total balance
        System.out.println("\n--- Exercise 4: Managing Customer's Accounts ---");
        BankCustomer customer = new BankCustomer("John Doe");
        System.out.println("Customer: " + customer.getName());
        
        // Create and add multiple accounts of different types
        BankAccount account2 = new BankAccount("ACC002", 1000);
        customer.addAccount(account2);
        
        SavingsAccount savingsAccount2 = new SavingsAccount("SAV002", 2000, 0.05);
        customer.addAccount(savingsAccount2);
        
        CheckingAccount checkingAccount2 = new CheckingAccount("CHK002", 500, 200);
        customer.addAccount(checkingAccount2);
        
        // Display individual account balances
        System.out.println("\nIndividual Account Balances:");
        int accountNum = 1;
        for (BankAccount acc : customer.getAccounts()) {
            System.out.println("  Account " + accountNum + " (" + acc.getAccountNumber() + "): $" + acc.getBalance());
            accountNum++;
        }
        
        // Display total balance across all accounts
        System.out.println("\nTotal Balance Across All Accounts: $" + customer.totalBalance());

        // Exercise 5: Transaction History
        // Create a BankAccount and demonstrate transaction recording
        // Add transactions to accounts and retrieve history
        System.out.println("\n--- Exercise 5: Transaction History ---");
        BankAccount account3 = new BankAccount("ACC003", 1000);
        System.out.println("Account: " + account3.getAccountNumber() + " | Initial Balance: $" + account3.getBalance());
        System.out.println("Initial Transaction History (empty): " + account3.getTransactionHistory());
        
        System.out.println("\nPerforming transactions:");
        System.out.println("\nTransaction #1: Deposit $500");
        account3.deposit(500);
        
        System.out.println("\nTransaction #2: Withdraw $200");
        account3.withdraw(200);
        
        System.out.println("\nTransaction #3: Deposit $300");
        account3.deposit(300);
        
        System.out.println("\nTransaction #4: Try to withdraw $2000 (will be rejected - not recorded)");
        account3.withdraw(2000);
        
        System.out.println("\nTransaction #5: Withdraw $100");
        account3.withdraw(100);
        
        System.out.println("\n--- Transaction History Report ---");
        System.out.println("Account: " + account3.getAccountNumber());
        System.out.println("Final Balance: $" + account3.getBalance());
        System.out.println("Total Transactions Recorded: " + account3.getTransactionHistory().size());
        System.out.println("\nTransaction List (in order):");
        int transNum = 1;
        for (String transaction : account3.getTransactionHistory()) {
            System.out.println("  " + transNum + ". " + transaction);
            transNum++;
        }

        // Exercise 6: Generate Banking Report
        // Generate and display a customer's banking report
        System.out.println("\n--- Exercise 6: Generate Banking Report ---");
        BankCustomer reportCustomer = new BankCustomer("Alice Johnson");
        
        // Create and add different account types
        BankAccount regAccount = new BankAccount("ACC100", 2500);
        reportCustomer.addAccount(regAccount);
        
        SavingsAccount savAccount = new SavingsAccount("SAV100", 5000, 0.04);
        reportCustomer.addAccount(savAccount);
        
        CheckingAccount chkAccount = new CheckingAccount("CHK100", 1500, 500);
        reportCustomer.addAccount(chkAccount);
        
        // Generate and display the banking report using toString() overrides
        reportCustomer.generateReport();

        // Exercise 7: Update Interest Rates
        // Update the interest rate and observe calculations
        System.out.println("\n--- Exercise 7: Update Interest Rates ---");
        SavingsAccount rateAccount = new SavingsAccount("SAV007", 1000, 0.05);
        System.out.println("Account: " + rateAccount.getAccountNumber() + " | Initial Balance: $" + rateAccount.getBalance() + " | Initial Rate: 5%");
        
        System.out.println("\nDeposit #1: $100 at 5% interest rate");
        rateAccount.deposit(100);
        System.out.println("Balance after deposit: $" + rateAccount.getBalance());
        
        System.out.println("\nChanging interest rate from 5% to 10%:");
        rateAccount.updateInterestRate(0.10);
        
        System.out.println("\nDeposit #2: $100 at 10% interest rate");
        rateAccount.deposit(100);
        System.out.println("Balance after deposit: $" + rateAccount.getBalance());
        
        System.out.println("\nChanging interest rate from 10% to 3%:");
        rateAccount.updateInterestRate(0.03);
        
        System.out.println("\nDeposit #3: $100 at 3% interest rate");
        rateAccount.deposit(100);
        System.out.println("Balance after deposit: $" + rateAccount.getBalance());
        
        System.out.println("\nFinal Account Balance: $" + rateAccount.getBalance());
        System.out.println("Transaction History:");
        int txNum = 1;
        for (String tx : rateAccount.getTransactionHistory()) {
            System.out.println("  " + txNum + ". " + tx);
            txNum++;
        }

        // Exercise 8: Override Withdrawal Method
        // Demonstrate overridden withdrawal method with withdrawal limit enforcement
        System.out.println("\n--- Exercise 8: Withdrawal Limits (Overdraft Restriction) ---");
        CheckingAccount limitAccount = new CheckingAccount("CHK008", 100, 200);
        System.out.println("Account: " + limitAccount.getAccountNumber() + " | Initial Balance: $" + limitAccount.getBalance() + " | Overdraft Limit: $" + limitAccount.getOverdraftLimit());
        System.out.println("Total Available (Balance + Overdraft): $" + (limitAccount.getBalance() + limitAccount.getOverdraftLimit()));
        
        System.out.println("\nWithdrawal #1: $150 (within total available of $300)");
        limitAccount.withdraw(150);  // $100 + $200 = $300 available; $150 allowed
        System.out.println("Balance after withdrawal: $" + limitAccount.getBalance());
        
        System.out.println("\nWithdrawal #2: $200 (uses overdraft, at exact limit)");
        limitAccount.withdraw(200);  // Total available now $150; $200 exceeds limit
        System.out.println("Balance after withdrawal: $" + limitAccount.getBalance());
        
        System.out.println("\nWithdrawal #3: $50 (should exceed the remaining limit)");
        limitAccount.withdraw(50);  // Should be rejected
        System.out.println("Balance after attempted withdrawal: $" + limitAccount.getBalance());

        // Complete all exercises and print results
    }
}