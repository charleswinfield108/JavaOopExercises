# 🤖 AI Feature Specification — OOP Report

> This feature specification is part of the **JavaOopExercises** project.
> It defines reporting functionality to display customer and account information in a cohesive format.
> Reference the main **AI_SPEC** for project context and overall architecture.

---

## Feature Goal & Scope

### Feature Goal

Implement reporting functionality that generates a comprehensive summary of a customer's account portfolio, including all accounts and their details, with readable string representations for each account type.

### In Scope (Build Now)

- **generateReport() Method**: Create method in BankCustomer to display account summary
- **toString() Override**: Implement toString() in BankAccount class for basic display
- **toString() Override in Subclasses**: Implement toString() in SavingsAccount and CheckingAccount for specialized display
- **Report Formatting**: Display customer name, all accounts, and balances in organized format
- **Main Demo**: Console demonstration of complete customer report generation

### Out of Scope (Do NOT Build)

- File export or PDF generation
- Report formatting to files
- Report templates or customization
- Graphical reports or visualizations
- Historical reports or trend analysis
- Account filtering in reports
- Multi-customer comparison reports
- Report scheduling or automation
- Report archival or versioning

---

## Requirements Breakdown & User Flow

### Core Requirements

#### R1: Generate Report Method
- Add `generateReport()` method to BankCustomer class
- Method is public and returns void (prints to console)
- Displays customer name prominently
- Lists all accounts associated with customer
- Shows each account's details using toString()
- Displays individual account balances
- Shows total balance across all accounts
- Formats output in readable, organized manner

#### R2: Override toString() in Account Classes
- Override `toString()` in BankAccount class for basic account info
- Return string with format: "BankAccount{accountNumber='ACC001', balance=$1000.0}"
- Override `toString()` in SavingsAccount class
- Return string with format: "SavingsAccount{accountNumber='SAV001', balance=$2000.0, interestRate=5%}"
- Override `toString()` in CheckingAccount class
- Return string with format: "CheckingAccount{accountNumber='CHK001', balance=$500.0, overdraftLimit=$200.0}"

#### R3: Main Demo
- Demonstrate report generation in `Main.main()` method
- Create a BankCustomer with name
- Create multiple accounts of different types
- Add accounts to customer
- Call generateReport() to display full report
- Show console output with complete customer portfolio

### User Flow

```
1. Create BankCustomer with name
   ↓
2. Create multiple account objects (different types)
   ↓
3. Add accounts to customer
   ↓
4. Call generateReport()
   ↓
5. Report displays:
   - Customer name
   - List of all accounts with details
   - Individual balances
   - Total balance
   ↓
6. User sees complete portfolio in console
```

---

## Interfaces Involved (Classes & Methods)

### BankCustomer Class (Modified)

```java
public class BankCustomer {
    // Existing Attributes
    private String name;
    private List<BankAccount> accounts;
    
    // Existing Methods
    public void addAccount(BankAccount account)
    public double totalBalance()
    public String getName()
    public List<BankAccount> getAccounts()
    
    // New Method
    public void generateReport()
}
```

### BankAccount Class (Modified)

```java
public class BankAccount {
    // Existing code...
    
    // New Method
    @Override
    public String toString()
}
```

### SavingsAccount Class (Modified)

```java
public class SavingsAccount extends BankAccount {
    // Existing code...
    
    // New Method
    @Override
    public String toString()
}
```

### CheckingAccount Class (Modified)

```java
public class CheckingAccount extends BankAccount {
    // Existing code...
    
    // New Method
    @Override
    public String toString()
}
```

---

## Data, Validations & Expected Behavior

### Report Format Structure

The generateReport() method should display:
```
=== CUSTOMER REPORT ===
Customer Name: John Doe

Accounts:
[1] BankAccount{accountNumber='ACC001', balance=$1000.0}
[2] SavingsAccount{accountNumber='SAV001', balance=$2000.0, interestRate=0.05}
[3] CheckingAccount{accountNumber='CHK001', balance=$100.0, overdraftLimit=$200.0}

Account Balances:
- Account 1: $1000.00
- Account 2: $2000.00
- Account 3: $100.00

Total Balance: $3100.00
```

### toString() Output Formats

| Class | Format | Example |
|-------|--------|---------|
| BankAccount | BankAccount{accountNumber='X', balance=$Y} | BankAccount{accountNumber='ACC001', balance=$1000.0} |
| SavingsAccount | SavingsAccount{accountNumber='X', balance=$Y, interestRate=Z} | SavingsAccount{accountNumber='SAV001', balance=$2000.0, interestRate=0.05} |
| CheckingAccount | CheckingAccount{accountNumber='X', balance=$Y, overdraftLimit=$Z} | CheckingAccount{accountNumber='CHK001', balance=$100.0, overdraftLimit=$200.0} |

### Validation Rules

#### Generate Report
- Works with empty account list (displays "No accounts")
- Works with single account
- Works with multiple accounts
- Displays negative balances correctly (from overdrafts)
- Totals calculated correctly across all account types
- Report is readable and well-formatted

#### toString() Methods
- Used automatically by System.out.println()
- Provides meaningful account information
- Distinguishes between account types
- Displays all relevant account attributes
- Shows balance and special attributes (interest rate, overdraft limit)

---

## Expected Behavior Scenarios

### Scenario 1: Single Account Report
```
Customer: Jane Smith
Accounts: 1 BankAccount
Output shows:
  - Customer name
  - Account details via toString()
  - Balance: $1000.0
  - Total: $1000.0
```

### Scenario 2: Multiple Regular Accounts
```
Customer: Bob Johnson
Accounts: 2 BankAccounts
Output shows:
  - Both accounts with details
  - Balance 1: $500.0
  - Balance 2: $800.0
  - Total: $1300.0
```

### Scenario 3: Mixed Account Types
```
Customer: Alice Williams
Accounts:
  - BankAccount: $1000.0
  - SavingsAccount: $2000.0 (interestRate=0.05)
  - CheckingAccount: $500.0 (overdraftLimit=$200)

Output shows:
  - All accounts with toString() details
  - All balances
  - Total: $3500.0
```

### Scenario 4: Account with Overdraft
```
Customer: Charlie Brown
Accounts:
  - BankAccount: $500.0
  - CheckingAccount: -$100.0 (overdraftLimit=$200)

Output shows:
  - Negative balance displayed correctly
  - Total: $400.0
```

### Scenario 5: Empty Customer (No Accounts)
```
Customer: David Lee
Accounts: None

Output shows:
  - Customer name
  - "No accounts" or empty list
  - Total Balance: $0.0
```

---

## Acceptance Criteria

### AC1: Generate Report Method Implemented
- [ ] `generateReport()` method exists in BankCustomer class
- [ ] Method is public and returns void
- [ ] Displays customer name at top of report
- [ ] Lists all accounts in customer's account collection
- [ ] Shows each account's toString() representation
- [ ] Displays individual account balances
- [ ] Calculates and displays total balance correctly
- [ ] Output is formatted and readable

### AC2: BankAccount toString() Overridden
- [ ] `toString()` method exists in BankAccount class
- [ ] Returns string with format: "BankAccount{accountNumber='X', balance=$Y}"
- [ ] Includes account number from the object
- [ ] Includes balance from the object
- [ ] Works correctly when called via System.out.println()

### AC3: SavingsAccount toString() Overridden
- [ ] `toString()` method exists in SavingsAccount class
- [ ] Returns string with format: "SavingsAccount{accountNumber='X', balance=$Y, interestRate=Z}"
- [ ] Includes account number
- [ ] Includes current balance
- [ ] Includes interest rate (as decimal, e.g., 0.05)
- [ ] Distinguishes itself from parent BankAccount

### AC4: CheckingAccount toString() Overridden
- [ ] `toString()` method exists in CheckingAccount class
- [ ] Returns string with format: "CheckingAccount{accountNumber='X', balance=$Y, overdraftLimit=$Z}"
- [ ] Includes account number
- [ ] Includes current balance
- [ ] Includes overdraft limit
- [ ] Distinguishes itself from parent BankAccount

### AC5: Main Demo Runs Successfully
- [ ] Main method creates a BankCustomer
- [ ] Creates at least 2 different account types
- [ ] Adds all accounts to customer
- [ ] Calls generateReport()
- [ ] Report displays with:
  - Customer name
  - All accounts formatted with toString()
  - Individual balances
  - Total balance
- [ ] Program runs without exceptions
- [ ] Console output is clear and readable

### AC6: All Classes Work Together
- [ ] BankAccount, SavingsAccount, CheckingAccount all have toString()
- [ ] BankCustomer.generateReport() uses toString() from each account
- [ ] Report handles mixed account types correctly
- [ ] Report handles negative balances from overdrafts
- [ ] Total balance calculation is accurate

---

## How to Verify It Works

### Verification Checklist

1. **Compile & Run**
   ```bash
   javac *.java
   java Main
   ```
   - No compilation errors
   - Main runs without exceptions

2. **Visual Inspection**
   - Console output shows customer name
   - All accounts are listed with toString() details
   - Each account type is clearly identified (BankAccount, SavingsAccount, CheckingAccount)
   - Balances are displayed correctly
   - Total balance is calculated and shown
   - Formatting is clean and readable

3. **Test Scenarios** (Run These)
   - Single account → Report shows 1 account with balance
   - Two regular accounts → Report shows both, correct total
   - Mixed account types → Report distinguishes each type
   - Account with overdraft → Negative balance displayed correctly
   - All operations performed first → Report shows current state

4. **toString() Testing** (Call Directly)
   - `new BankAccount("ACC001", 1000).toString()` outputs correctly formatted string
   - `new SavingsAccount("SAV001", 2000, 0.05).toString()` shows interest rate
   - `new CheckingAccount("CHK001", 500, 200).toString()` shows overdraft limit
   - Each toString() includes all relevant information

5. **Edge Cases** (Should Handle Gracefully)
   - Customer with no accounts → Report shows "No accounts" or empty list
   - Single account → Report displays correctly
   - Very large balance → Displays without truncation
   - Very small/zero balance → Displays correctly
   - Negative balance (overdraft) → Displayed with minus sign
   - Multiple toString() calls → Consistent output each time
   - generateReport() called multiple times → Same output each call

---

## Reference to Main AI Spec

This feature implements the reporting functionality outlined in the **JavaOopExercises** project specification:
- **Feature Type**: Object-Oriented Programming Exercise
- **Core Concept**: toString() method overriding and polymorphic behavior
- **Architecture Pattern**: Template method for report generation with polymorphic display
- **Testing**: Output formatting and correctness provide testable behavior

---

## Implementation Notes

- The generateReport() method should iterate through all accounts and call their toString() methods
- Each BankAccount subclass (SavingsAccount, CheckingAccount) should override toString() with its own specific format
- The toString() method from Object class should be properly overridden (use @Override annotation)
- Report output should use System.out.println() for line-by-line display
- Consider using String.format() for formatted balance display (e.g., $1000.00)
- The report should work with polymorphism - calling toString() on a reference of type BankAccount should execute the appropriate overridden method

---

## Files & Location

- **This File**: `./ai/features/# 🤖 AI_FEATURE_OOP Report.feature.md`
- **Implementation**: 
  - Modified `BankAccount.java` (add toString() override)
  - Modified `SavingsAccount.java` (add toString() override)
  - Modified `CheckingAccount.java` (add toString() override)
  - Modified `BankCustomer.java` (add generateReport() method)
- **Main Demo**: `Main.java` (Exercise 5+ demonstrated in `main()` method)
