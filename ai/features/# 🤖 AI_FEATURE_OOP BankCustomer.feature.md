# 🤖 AI Feature Specification — OOP BankCustomer

> This feature specification is part of the **JavaOopExercises** project.
> It defines the BankCustomer class that manages multiple bank accounts for a single customer.
> Reference the main **AI_SPEC** for project context and overall architecture.

---

## Feature Goal & Scope

### Feature Goal

Implement a BankCustomer class that manages a customer's personal information and their collection of bank accounts, providing functionality to add accounts and calculate total balance across all accounts.

### In Scope (Build Now)

- **BankCustomer Class**: Customer entity that holds multiple accounts
- **Customer Name Field**: Store customer's name
- **Account Collection**: Store multiple BankAccount objects
- **Constructor**: Initialize customer with name and empty account list
- **Add Account Method**: Ability to associate accounts with customer
- **Total Balance Method**: Calculate sum of all account balances
- **Main Demo**: Console demonstration of customer with multiple accounts

### Out of Scope (Do NOT Build)

- Customer ID generation
- Account removal or modification
- Customer deletion
- Account transfer between customers
- Customer validation or verification
- Persistent storage or database
- User authentication or security
- Transaction history across all accounts
- Overdraft or interest management at customer level

---

## Requirements Breakdown & User Flow

### Core Requirements

#### R1: Create BankCustomer Class
- Define a new class named `BankCustomer`
- Use public access modifier

#### R2: Add Fields (Name + Accounts)
- Add `name` field (String type)
- Add accounts collection field to store multiple BankAccount objects
- Use `List<BankAccount>` for the collection
- Both fields should be private

#### R3: Constructor
- Create a constructor that accepts `name` parameter (String)
- Initialize the `name` field with provided value
- Initialize the accounts collection as empty (new ArrayList or equivalent)

#### R4: Add Account Method
- Create `addAccount(BankAccount account)` method
- Method is public and accepts a BankAccount object
- Add the account to the customer's accounts collection
- No validation of duplicates required

#### R5: Total Balance Method
- Create `totalBalance()` method
- Method is public and returns double
- Calculate the sum of all account balances
- Handle both positive and negative balances (from checking overdrafts)
- Return sum even if negative

#### R6: Main Demo
- Demonstrate BankCustomer functionality in the `Main.main()` method
- Create a BankCustomer instance with a name
- Create multiple BankAccount objects (can be different types: regular, savings, checking)
- Add all accounts to the customer using addAccount
- Display customer name and individual account balances
- Display total balance across all accounts using `System.out.println()`

### User Flow

```
1. Create a BankCustomer with name
   ↓
2. Create multiple BankAccount objects:
   - Can be regular BankAccount
   - Can be SavingsAccount
   - Can be CheckingAccount
   ↓
3. Add accounts to customer using addAccount()
   ↓
4. Query customer information:
   - Get customer name
   - Get individual account balances
   - Calculate total balance
   ↓
5. Results displayed in console
```

---

## Interfaces Involved (Classes & Methods)

### BankCustomer Class

```java
public class BankCustomer {
    // Attributes
    private String name;
    private List<BankAccount> accounts;
    
    // Constructor
    public BankCustomer(String name)
    
    // Methods
    public void addAccount(BankAccount account)
    public double totalBalance()
    public String getName()
    public List<BankAccount> getAccounts()
}
```

---

## Data, Validations & Expected Behavior

### Data Structures

| Entity | Attribute | Type | Constraints |
|--------|-----------|------|-------------|
| BankCustomer | name | String | Non-empty, stores customer name |
| BankCustomer | accounts | List<BankAccount> | Empty on creation, grows as accounts added |

### Validation Rules

#### Constructor
- Name must be provided (non-null)
- Account list initialized as empty collection

#### Add Account
- BankAccount objects are added to customer's collection
- Same account can be added multiple times (no duplicate checking)
- No limit on number of accounts per customer

#### Total Balance Calculation
- Sum all account balances: `totalBalance = sum(account.balance for each account in accounts)`
- Formula: `totalBalance = account1.balance + account2.balance + ... + accountN.balance`
- Handles positive balances normally
- Handles negative balances from overdrafts correctly
- Example with 3 accounts:
  - Regular account: $500
  - Savings account: $2000
  - Checking account: -$100 (overdraft)
  - Total: $500 + $2000 + (-$100) = $2400

---

## Expected Behavior Scenarios

### Scenario 1: Customer Creation
```
Customer: John Doe
Initial Accounts: 0 (empty list)
```

### Scenario 2: Adding Single Account
```
Customer: John Doe
→ Add BankAccount(ACC001, $1000)
Total Balance: $1000 ✓
```

### Scenario 3: Multiple Regular Accounts
```
Customer: Jane Smith
→ Add BankAccount(ACC002, $500)
→ Add BankAccount(ACC003, $800)
Total Balance: $500 + $800 = $1300 ✓
```

### Scenario 4: Mixed Account Types
```
Customer: Bob Johnson
Accounts:
  - BankAccount(ACC004, $1000)
  - SavingsAccount(SAV001, $2000, 5%)
  - CheckingAccount(CHK001, $100, $200 overdraft)

Total Balance: $1000 + $2000 + $100 = $3100 ✓
```

### Scenario 5: Account with Overdraft
```
Customer: Alice Williams
Accounts:
  - BankAccount(ACC005, $500)
  - CheckingAccount(CHK002, -$50, $200 overdraft)

Total Balance: $500 + (-$50) = $450 ✓
```

### Scenario 6: Operations Affecting Balance
```
Customer: Charlie Brown
Accounts:
  - BankAccount(ACC006, $1000)
  - SavingsAccount(SAV002, $1000, 5%)

Initial Total: $2000

→ Deposit $100 in ACC006 → Total: $2100
→ Deposit $100 in SAV002 (with 5% interest adds $5) → Total: $2205
→ Withdraw $200 from ACC006 → Total: $2005
```

---

## Acceptance Criteria

### AC1: BankCustomer Class Created
- [ ] `BankCustomer` class exists and can be instantiated
- [ ] Class is public and properly named
- [ ] No compilation errors

### AC2: Fields Properly Implemented
- [ ] `name` field exists (String type, private)
- [ ] `accounts` field exists (List<BankAccount> type, private)
- [ ] Both fields are properly initialized

### AC3: Constructor Implementation
- [ ] Constructor accepts `name` parameter
- [ ] Initializes `name` field with provided value
- [ ] Initializes `accounts` collection as empty (ArrayList or equivalent)
- [ ] Can be instantiated successfully

### AC4: Add Account Method Works
- [ ] `addAccount(BankAccount account)` method exists and is public
- [ ] Accepts BankAccount objects (including subclasses like SavingsAccount, CheckingAccount)
- [ ] Adds account to the customer's collection
- [ ] Allows multiple accounts to be added
- [ ] Accounts persist in collection after being added

### AC5: Total Balance Method Works
- [ ] `totalBalance()` method exists and is public
- [ ] Returns double value
- [ ] Correctly sums all account balances
- [ ] Handles positive balances normally
- [ ] Handles negative balances (overdrafts) correctly
- [ ] Returns correct sum even with mixed account types

### AC6: Main Demo Runs Successfully
- [ ] Main method creates a BankCustomer instance
- [ ] Creates at least 2 different BankAccount instances (can be different types)
- [ ] Adds all accounts to customer using addAccount
- [ ] Displays customer name
- [ ] Displays individual account balances
- [ ] Displays total balance using totalBalance()
- [ ] Program runs without exceptions
- [ ] Console output is clear and shows all information

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
   - All account balances are displayed
   - Total balance calculation is shown
   - Total correctly sums all individual balances

3. **Test Scenarios** (Run These)
   - Create BankCustomer "John Doe"
   - Add BankAccount(ACC001, $1000)
   - Add BankAccount(ACC002, $500)
   - Verify totalBalance() returns $1500
   
   - Create BankCustomer "Jane Smith"
   - Add SavingsAccount(SAV001, $1000, 0.05)
   - Add CheckingAccount(CHK001, $500, $200 overdraft)
   - Verify totalBalance() returns $1500
   
   - Perform deposit: balance changes in specific account
   - Verify totalBalance() reflects new sum

4. **Edge Cases** (Should Handle Gracefully)
   - Customer with no accounts → totalBalance() returns 0
   - Customer with single account → totalBalance() equals account balance
   - Customer with account in overdraft → totalBalance() handles negative correctly
   - Multiple accounts of same type → All counted in total
   - Mix of all account types → All counted in total
   - Adding same account multiple times → Works (appears multiple times in collection)

---

## Reference to Main AI Spec

This feature implements the customer management functionality outlined in the **JavaOopExercises** project specification:
- **Feature Type**: Object-Oriented Programming Exercise
- **Core Concept**: Composition pattern - customer contains multiple account objects
- **Architecture Pattern**: Aggregation of BankAccount objects into a higher-level BankCustomer entity
- **Testing**: Collection management and balance aggregation provide testable behavior

---

## Files & Location

- **This File**: `./ai/features/# 🤖 AI_FEATURE_OOP BankCustomer.feature.md`
- **Implementation**: `BankCustomer.java` (uses `BankAccount.java`, `SavingsAccount.java`, `CheckingAccount.java`)
- **Main Demo**: `Main.java` (Exercise 4 demonstrated in `main()` method)
