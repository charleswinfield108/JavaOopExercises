# Instructions

1. Clone this repository and create your own. 
2. Open the project folder in VS Code.
	- Install the 'Extension Pack for Java' extension
	- If you're getting an error about needing to install the JDK and you have already installed it, it means that you need to set your environment variables properly.
3. Complete each exercise in the given order. Each time you finish an exercise, perform a commit with a relevant commit description. The exercises will ask you to:
	- Create new classes. Each class is in its own file (see Person.java)
	- Create methods and attributes
	- Use inheritance
	- Manipulate data and show results with `System.out.println()` -- The (Main) part of each exercises needs to be done in the main method of the Main class.

# Exercise 1: Creating a Bank Account

1. Create a BankAccount class with attributes: accountNumber (String) and balance (double).
2. Implement a constructor to initialize the account details.
3. Add a deposit(double amount) method to increase the balance.
4. Add a withdraw(double amount) method to decrease the balance. Ensure the withdrawal amount is less than the balance.
5. (Main) Create an instance of BankAccount and demonstrate deposit and withdrawal operations.

# Exercise 2: Creating a Savings Account

1. Extend the BankAccount class to create a SavingsAccount class.
2. Add an attribute interestRate (double) to the SavingsAccount class.
3. Implement a constructor to initialize the account details and interest rate.
4. Override the deposit(double amount) method to add additional interest based on the interest rate.
5. (Main) Create an instance of SavingsAccount and demonstrate deposit operations with interest.

# Exercise 3: Creating a Checking Account

1. Extend the BankAccount class to create a CheckingAccount class.
2. Add an attribute overdraftLimit (double) to the CheckingAccount class.
3. Implement a constructor to initialize the account details and overdraft limit.
4. Override the withdraw(double amount) method to allow overdraft within the overdraft limit.
5. (Main) Create an instance of CheckingAccount and demonstrate withdrawal operations with overdraft.

# Exercise 4: Managing Customer's Accounts

1. Create a BankCustomer class with attributes: name (String) and a collection of BankAccount objects.
2. Implement a constructor to initialize the customer's name and accounts.
3. Add a addAccount(BankAccount account) method to add accounts to the customer's collection.
4. Implement a totalBalance() method to calculate the total balance across all accounts.
5. (Main) Create an instance of BankCustomer, add multiple accounts, and display the total balance.

# Exercise 5: Transaction History

1. Extend the BankAccount class to add a transactions list to store transaction history.
2. Implement a recordTransaction(String transaction) method to add transactions to the list.
3. Add a getTransactionHistory() method to retrieve and display the transaction history.
4. Update the deposit and withdrawal methods to record transactions.
5. (Main) Demonstrate recording and retrieving transaction history.

# Exercise 6: Generate Banking Report

1. Create a method generateReport() in the BankCustomer class to display a summary of the customer's accounts and balances.
2. Override the toString() method in BankAccount, SavingsAccount, and CheckingAccount to display account-specific information.
3. (Main) Call the generateReport() method for the customer and display the banking report.

# Exercise 7: Update Interest Rates

1. Implement a method updateInterestRate(double newRate) in the SavingsAccount class to update the interest rate.
2. (Main) Demonstrate changing the interest rate and performing deposits to see the updated interest calculation.

# Exercise 8: Override Withdrawal Method

1. Override the withdraw(double amount) method in the CheckingAccount class to restrict overdraft.
2. If the withdrawal amount exceeds the balance + overdraft limit, prevent the withdrawal.
3. (Main) Demonstrate the overridden withdrawal method by attempting to withdraw beyond the overdraft limit.
