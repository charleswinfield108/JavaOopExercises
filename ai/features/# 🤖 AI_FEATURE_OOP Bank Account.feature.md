# 🤖 AI Feature Specification — OOP BankAccount

> This feature specification is part of the **JavaOopExercises** project.
> It defines the basic BankAccount class with fundamental banking operations.
> Reference the main **AI_SPEC** for project context and overall architecture.

---

## Feature Goal & Scope

### Feature Goal

Implement a basic BankAccount class using Object-Oriented Programming principles that allows users to create bank accounts and perform fundamental deposit and withdrawal operations.

### In Scope (Build Now)

- **BankAccount Class**: Core account functionality with account number and balance
- **Constructor**: Initialize account details
- **Deposit Method**: Add funds to account
- **Withdraw Method**: Remove funds from account with validation
- **Main Demo**: Console demonstration of BankAccount operations

### Out of Scope (Do NOT Build)

- Account subclasses (SavingsAccount, CheckingAccount)
- Customer management or multiple account handling
- Transaction history tracking
- Interest calculations
- Overdraft protection
- Persistent storage or file I/O
- User authentication

---

## Requirements Breakdown & User Flow

### Core Requirements

#### R1: Create BankAccount Class
- Define a new class named `BankAccount`
- Use public access modifier

#### R2: Add Basic Fields
- Add `accountNumber` field (String type)
- Add `balance` field (double type)
- Both fields should be private

#### R3: Implement Constructor
- Create a constructor that accepts `accountNumber` and `initialBalance` parameters
- Initialize both fields with provided values

#### R4: Deposit Method
- Create `deposit(double amount)` method
- Increase the balance by the amount
- Method should be public

#### R5: Withdraw Method
- Create `withdraw(double amount)` method
- Decrease the balance by the amount
- Only allow withdrawal if amount ≤ current balance
- Validate and reject invalid withdrawals
- Method should be public

#### R6: Main Demo
- Demonstrate BankAccount functionality in the `Main.main()` method
- Create a BankAccount instance
- Show deposit operation
- Show withdrawal operation
- Display results using `System.out.println()`

### User Flow

```
1. User creates a BankAccount with account number and initial balance
   ↓
2. User performs deposit operation
   → Balance increases
   ↓
3. User performs withdrawal operation
   → Balance decreases (if valid)
   ↓
4. Results displayed in console
```

---

## Interfaces Involved (Classes & Methods)

### BankAccount Class

```java
public class BankAccount {
    // Attributes
    private String accountNumber;
    private double balance;
    
    // Constructor
    public BankAccount(String accountNumber, double initialBalance)
    
    // Methods
    public void deposit(double amount)
    public void withdraw(double amount)
    public double getBalance()
    public String getAccountNumber()
}
```

---

## Data, Validations & Expected Behavior

### Data Structures

| Entity | Attribute | Type | Constraints |
|--------|-----------|------|-------------|
| BankAccount | accountNumber | String | Non-empty, unique identifier |
| BankAccount | balance | double | ≥ 0 |

### Validation Rules

#### Deposit Operation
- Amount must be positive (> 0)
- Balance is updated: `balance += amount`
- Operation succeeds

#### Withdraw Operation
- Amount must be positive (> 0)
- Amount must not exceed current balance
- Only allow withdrawal if: `amount ≤ balance`
- If valid: `balance -= amount`
- If invalid: reject operation, balance unchanged

---

## Expected Behavior Scenarios

### Scenario 1: Basic Deposit
```
Account: ACC001, Initial Balance: $1000
→ Deposit $500 → Balance: $1500 ✓
```

### Scenario 2: Basic Withdrawal (Valid)
```
Account: ACC001, Balance: $1500
→ Withdraw $200 → Balance: $1300 ✓
```

### Scenario 3: Withdrawal Rejection (Invalid)
```
Account: ACC001, Balance: $1300
→ Withdraw $2000 → FAIL (exceeds balance) ✓
→ Balance remains: $1300 ✓
```

---

## Acceptance Criteria

### AC1: BankAccount Class Created
- [ ] `BankAccount` class exists and can be instantiated
- [ ] Class is public and properly named
- [ ] No compilation errors

### AC2: Basic Fields Implemented
- [ ] `accountNumber` field exists (String type, private)
- [ ] `balance` field exists (double type, private)
- [ ] Both fields are properly initialized

### AC3: Constructor Implementation
- [ ] Constructor accepts `accountNumber` (String) and `initialBalance` (double)
- [ ] Constructor properly initializes both fields
- [ ] Constructor can be called with valid parameters

### AC4: Deposit Method Works
- [ ] `deposit(double amount)` method exists and is public
- [ ] Deposit correctly increases balance: `balance += amount`
- [ ] Positive amounts are accepted
- [ ] Balance updates are reflected

### AC5: Withdraw Method Works
- [ ] `withdraw(double amount)` method exists and is public
- [ ] Withdraw correctly decreases balance: `balance -= amount`
- [ ] Only allows withdrawal if `amount ≤ balance`
- [ ] Rejects withdrawals that exceed balance
- [ ] Balance remains unchanged for rejected withdrawals

### AC6: Main Demo Runs Successfully
- [ ] Main method creates a BankAccount instance
- [ ] Demonstrates at least one deposit operation
- [ ] Demonstrates at least one withdrawal operation
- [ ] Displays balance and operation results using `System.out.println()`
- [ ] Program runs without exceptions
- [ ] Console output is clear and shows expected results

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
   - Deposit operation displays updated balance
   - Withdrawal operation displays updated balance
   - All balances are correct

3. **Test Scenarios** (Run These)
   - Create BankAccount with account number "ACC001" and initial balance $1000
   - Deposit $500 → Verify balance is $1500
   - Withdraw $300 → Verify balance is $1200
   - Try to withdraw $2000 → Verify it's rejected and balance remains $1200

4. **Edge Cases** (Should Handle Gracefully)
   - Withdraw amount equal to balance → Should succeed, balance becomes $0
   - Try to withdraw more than balance → Should be rejected
   - Deposit with zero or negative amount → Should be handled appropriately
   - Multiple deposits and withdrawals in sequence → All should work correctly

---

## Reference to Main AI Spec

This feature implements the basic BankAccount functionality outlined in the **JavaOopExercises** project specification:
- **Feature Type**: Object-Oriented Programming Exercise
- **Core Concept**: Class definition, fields, constructors, and methods
- **Architecture Pattern**: Encapsulation with private fields and public methods
- **Testing**: Validation rules and basic operations provide testable behavior

---

## Files & Location

- **This File**: `./ai/features/# 🤖 AI_FEATURE_OOP Bank Account.feature.md`
- **Implementation**: `BankAccount.java`
- **Main Demo**: `Main.java` (Exercise 1 demonstrated in `main()` method)
