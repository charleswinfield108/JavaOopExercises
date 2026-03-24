# 🤖 AI Feature Specification — OOP Extend BankAccount

> This feature specification is part of the **JavaOopExercises** project.
> It extends the BankAccount class to include transaction history tracking and recording.
> Reference the main **AI_SPEC** for project context and overall architecture.

---

## Feature Goal & Scope

### Feature Goal

Extend the BankAccount class to track and maintain a complete history of all transactions (deposits and withdrawals) performed on the account, providing functionality to record and retrieve transaction details.

### In Scope (Build Now)

- **Transactions List Field**: Store all transaction records as strings
- **Record Transaction Method**: Add new transactions to the history
- **Get Transaction History Method**: Retrieve and display all recorded transactions
- **Update Deposit Method**: Record deposit transactions automatically
- **Update Withdraw Method**: Record withdrawal transactions automatically
- **Main Demo**: Console demonstration of transaction recording and history retrieval

### Out of Scope (Do NOT Build)

- Transaction timestamps or dates
- Transaction filtering or search
- Transaction reversal or cancellation
- Transaction persistence or storage
- Transaction categorization
- Transaction fees or charges
- Multi-user transaction tracking
- Concurrent transaction handling
- Account reconciliation

---

## Requirements Breakdown & User Flow

### Core Requirements

#### R1: Add Transactions List
- Extend BankAccount class with a transactions list
- Use `List<String>` to store transaction records
- Initialize as empty list in constructor
- Field should be private

#### R2: Record Transaction Method
- Implement `recordTransaction(String transaction)` method
- Method is private (called internally, not by users)
- Accepts a transaction description string
- Adds transaction string to the transactions list

#### R3: Get Transaction History Method
- Implement `getTransactionHistory()` method that returns the transaction history
- Method is public and returns `List<String>`
- Returns a copy or the full list of all transactions
- Returns empty list if no transactions recorded

#### R4: Update Deposit/Withdraw Methods
- Modify existing `deposit(double amount)` method to record transactions
- Modify existing `withdraw(double amount)` method to record transactions
- After updating balance, call recordTransaction with appropriate message
- Deposit format: "Deposit: +$amount"
- Withdraw format: "Withdraw: -$amount"

#### R5: Main Demo
- Demonstrate transaction history in the `Main.main()` method
- Create a BankAccount instance
- Perform multiple operations: deposits and withdrawals
- After each operation, display the transaction history
- Show how transaction list grows with each operation
- Display final complete transaction history using `System.out.println()`

### User Flow

```
1. Create BankAccount with initial balance
   → Transactions list initialized as empty
   ↓
2. Perform first deposit
   → Balance increases
   → Transaction recorded: "Deposit: +$amount"
   → Transaction history now has 1 entry
   ↓
3. Perform withdrawal
   → Balance decreases
   → Transaction recorded: "Withdraw: -$amount"
   → Transaction history now has 2 entries
   ↓
4. Request transaction history
   → System returns list of all transactions in order
   → User can view complete account transaction audit trail
```

---

## Interfaces Involved (Classes & Methods)

### Extended BankAccount Class

```java
public class BankAccount {
    // Existing Attributes
    private String accountNumber;
    private double balance;
    
    // New Attribute
    private List<String> transactions;
    
    // Existing Constructor (modified)
    public BankAccount(String accountNumber, double initialBalance)
    
    // Existing Methods (modified)
    public void deposit(double amount)
    public void withdraw(double amount)
    
    // New Methods
    private void recordTransaction(String transaction)
    public List<String> getTransactionHistory()
    
    // Existing Accessor Methods
    public double getBalance()
    public String getAccountNumber()
}
```

---

## Data, Validations & Expected Behavior

### Data Structures

| Entity | Attribute | Type | Constraints |
|--------|-----------|------|-------------|
| BankAccount | accountNumber | String | Inherited, non-empty |
| BankAccount | balance | double | Inherited, ≥ 0 |
| BankAccount | transactions | List<String> | New, empty on creation, grows with operations |

### Transaction Record Format

| Operation | Format | Example |
|-----------|--------|---------|
| Deposit | "Deposit: +$amount" | "Deposit: +$500.0" |
| Withdraw | "Withdraw: -$amount" | "Withdraw: -$200.0" |

### Validation Rules

#### Deposit with Transaction Recording
- Amount must be positive (> 0)
- Balance is updated: `balance += amount`
- Transaction recorded: `"Deposit: +$amount"`
- Transaction added to list

#### Withdraw with Transaction Recording
- Amount must be positive (> 0)
- Amount must not exceed balance (from parent class logic)
- If valid: `balance -= amount` and record: `"Withdraw: -$amount"`
- If invalid: operation rejected, no transaction recorded

#### Get Transaction History
- Returns list of all recorded transactions
- Transactions in order they were recorded (FIFO)
- Can return empty list if no transactions exist
- List can be read multiple times

---

## Expected Behavior Scenarios

### Scenario 1: Account Creation - Empty History
```
Account: ACC001, Initial Balance: $1000
Transactions: [] (empty)
```

### Scenario 2: First Deposit - Transaction Recorded
```
Account: ACC001, Initial Balance: $1000
→ Deposit $500
   - Balance: $1500
   - Transaction recorded: "Deposit: +$500.0"
   - History: ["Deposit: +$500.0"]
```

### Scenario 3: Single Withdrawal - Transaction Recorded
```
Account: ACC001, Balance: $1500
→ Withdraw $200
   - Balance: $1300
   - Transaction recorded: "Withdraw: -$200.0"
   - History: ["Deposit: +$500.0", "Withdraw: -$200.0"]
```

### Scenario 4: Multiple Operations - Full History
```
Account: ACC001, Initial Balance: $1000
→ Deposit $500 → History: ["Deposit: +$500.0"]
→ Withdraw $200 → History: ["Deposit: +$500.0", "Withdraw: -$200.0"]
→ Deposit $300 → History: ["Deposit: +$500.0", "Withdraw: -$200.0", "Deposit: +$300.0"]
→ Withdraw $100 → History: ["Deposit: +$500.0", "Withdraw: -$200.0", "Deposit: +$300.0", "Withdraw: -$100.0"]
Final Balance: $1500
```

### Scenario 5: Invalid Withdrawal - No Transaction Recorded
```
Account: ACC001, Balance: $1300
→ Try to Withdraw $2000 (exceeds balance)
   - Operation REJECTED
   - Balance unchanged: $1300
   - NO transaction recorded
   - History unchanged
```

### Scenario 6: Inherited Withdraw Method Still Works
```
Account: ACC001, Balance: $1300
→ Withdraw $1300 (exact balance)
   - Balance: $0
   - Transaction recorded: "Withdraw: -$1300.0"
   - History updated
```

---

## Acceptance Criteria

### AC1: Transactions List Field Added
- [ ] `transactions` field exists (List<String> type, private)
- [ ] Initialized as empty list in constructor
- [ ] List is created for each new BankAccount instance

### AC2: Record Transaction Method Implemented
- [ ] `recordTransaction(String transaction)` method exists and is private
- [ ] Accepts a transaction description string
- [ ] Adds transaction to the list
- [ ] Called after successful operations

### AC3: Get Transaction History Method Implemented
- [ ] `getTransactionHistory()` method exists and is public
- [ ] Returns List<String> containing all transactions
- [ ] Returns transactions in order recorded (FIFO)
- [ ] Returns empty list for new accounts with no transactions

### AC4: Deposit Method Updated
- [ ] Existing deposit logic works unchanged
- [ ] After balance update, calls recordTransaction
- [ ] Records in format: "Deposit: +$amount"
- [ ] Transactions appear in history

### AC5: Withdraw Method Updated
- [ ] Existing withdraw validation logic works unchanged
- [ ] After valid withdrawal, calls recordTransaction
- [ ] Records in format: "Withdraw: -$amount"
- [ ] Invalid withdrawals do NOT record transactions
- [ ] Transactions appear in history

### AC6: Main Demo Runs Successfully
- [ ] Main method creates a BankAccount instance
- [ ] Performs multiple deposit operations (at least 2)
- [ ] Performs multiple withdrawal operations (at least 2)
- [ ] Displays transaction history after operations
- [ ] Shows each transaction in output
- [ ] Shows final balance and complete transaction list
- [ ] Program runs without exceptions

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
   - Console output shows account creation
   - Each operation (deposit/withdraw) is shown
   - Transaction history displays after operations
   - Transactions are listed in correct order
   - Transaction format is clear (e.g., "Deposit: +$500.0")

3. **Test Scenarios** (Run These)
   - Create BankAccount(ACC001, $1000)
   - Verify initial history is empty: []
   
   - Deposit $500
   - Verify history: ["Deposit: +$500.0"]
   - Verify balance: $1500
   
   - Withdraw $200
   - Verify history: ["Deposit: +$500.0", "Withdraw: -$200.0"]
   - Verify balance: $1300
   
   - Deposit $300
   - Verify history has 3 entries
   - Verify balance: $1600
   
   - Try to withdraw $2000 (invalid)
   - Verify history still has 3 entries (no new transaction)
   - Verify balance unchanged: $1600

4. **Edge Cases** (Should Handle Gracefully)
   - New account with no operations → Empty history: []
   - Single deposit → History has 1 entry
   - Single withdrawal → History has 1 entry
   - Multiple same-type operations → All recorded
   - Mixed operations → All recorded in order
   - Invalid operation → Not recorded in history
   - Last operation invalid → History stops before invalid attempt
   - getTransactionHistory() called multiple times → Same result each time
   - Display very long history → All entries shown

---

## Reference to Main AI Spec

This feature implements the transaction tracking functionality outlined in the **JavaOopExercises** project specification:
- **Feature Type**: Object-Oriented Programming Exercise
- **Core Concept**: Collection management and audit logging
- **Architecture Pattern**: Observer/logging pattern with transaction recording
- **Testing**: Transaction order and completeness provide testable behavior

---

## Implementation Notes

- This feature extends the existing BankAccount class (does NOT create new subclasses)
- The transactions list is NOT part of the inherited interface for subclasses unless they call super methods
- SavingsAccount and CheckingAccount will inherit this transaction recording if they use super.deposit() and super.withdraw()
- Transaction formatting uses the toString representation of double values

---

## Files & Location

- **This File**: `./ai/features/# 🤖 AI_FEATURE_OOP Extend BankAccount.feature.md`
- **Implementation**: Modified `BankAccount.java` (add transactions list and methods)
- **Main Demo**: `Main.java` (Exercise 5 demonstrated in `main()` method)
