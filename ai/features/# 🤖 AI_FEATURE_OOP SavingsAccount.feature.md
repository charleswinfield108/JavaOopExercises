# 🤖 AI Feature Specification — OOP SavingsAccount

> This feature specification is part of the **JavaOopExercises** project.
> It defines the SavingsAccount class that extends BankAccount with interest rate functionality.
> Reference the main **AI_SPEC** for project context and overall architecture.

---

## Feature Goal & Scope

### Feature Goal

Implement a SavingsAccount class that extends BankAccount to provide specialized account functionality with automatic interest calculation on deposits.

### In Scope (Build Now)

- **SavingsAccount Class**: Specialized account type for savings
- **Inheritance**: Extend BankAccount class
- **Interest Rate Field**: Store interest rate as a property
- **Constructor**: Initialize account details with interest rate
- **Deposit Override**: Override parent deposit method to apply interest
- **Main Demo**: Console demonstration of SavingsAccount operations with interest

### Out of Scope (Do NOT Build)

- Separate interest calculation scheduling
- Multiple interest rate changes
- Compound interest calculations over time periods
- CheckingAccount or other account types
- Customer management or transaction history
- Persistent storage or file I/O
- User authentication

---

## Requirements Breakdown & User Flow

### Core Requirements

#### R1: Create SavingsAccount Class
- Define a new class named `SavingsAccount`
- Use public access modifier

#### R2: Extend BankAccount
- `SavingsAccount` must inherit from `BankAccount`
- Use `extends` keyword to establish inheritance relationship

#### R3: Add Interest Rate Field
- Add `interestRate` field (double type)
- Store as private field
- Represents interest percentage (e.g., 0.05 = 5%)

#### R4: Constructor With Interest
- Create a constructor that accepts `accountNumber`, `initialBalance`, and `interestRate` parameters
- Call parent constructor with `accountNumber` and `initialBalance`
- Initialize the `interestRate` field with provided value

#### R5: Override Deposit Method
- Override the inherited `deposit(double amount)` method
- Calculate interest: `interest = amount * interestRate`
- Add interest to the deposit amount
- Update balance: `balance += amount + interest`
- Final balance increases by both deposit and interest

#### R6: Main Demo
- Demonstrate SavingsAccount functionality in the `Main.main()` method
- Create a SavingsAccount instance with account number, initial balance, and interest rate
- Show deposit operation with interest calculation
- Display balance updates and interest value using `System.out.println()`

### User Flow

```
1. User creates a SavingsAccount with account number, initial balance, and interest rate
   ↓
2. User performs deposit operation
   → Interest is automatically calculated
   → Balance increases by both deposit amount and interest
   ↓
3. Results displayed in console showing:
   - Original deposit amount
   - Interest earned
   - Final balance after deposit + interest
```

---

## Interfaces Involved (Classes & Methods)

### SavingsAccount Class

```java
public class SavingsAccount extends BankAccount {
    // Attributes
    private double interestRate;
    
    // Constructor
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate)
    
    // Overridden Methods
    @Override
    public void deposit(double amount)
}
```

---

## Data, Validations & Expected Behavior

### Data Structures

| Entity | Attribute | Type | Constraints |
|--------|-----------|------|-------------|
| SavingsAccount | accountNumber | String | Inherited from BankAccount |
| SavingsAccount | balance | double | Inherited from BankAccount, ≥ 0 |
| SavingsAccount | interestRate | double | 0–1 (decimal), e.g., 0.05 = 5% |

### Validation Rules

#### Deposit with Interest
- Amount must be positive (> 0)
- Interest is calculated: `interest = amount * interestRate`
- Balance updated: `balance += amount + interest`
- Both deposit and interest are added to the account
- Example: Deposit $100 at 5% interest
  - Interest earned: $100 × 0.05 = $5
  - Total added to balance: $105

#### Inherited Withdrawal
- Withdrawal still uses parent BankAccount logic
- No interest applied to withdrawals
- Amount must not exceed current balance

---

## Expected Behavior Scenarios

### Scenario 1: Savings Account Creation
```
Account: SAV001
Initial Balance: $1000
Interest Rate: 5% (0.05)
```

### Scenario 2: Deposit with Interest Applied
```
SavingsAccount with Balance: $1000, Interest Rate: 5%
→ Deposit $100 →
   - Deposit amount: $100
   - Interest earned: $100 × 0.05 = $5
   - Total added: $105
   - Final Balance: $1105 ✓
```

### Scenario 3: Multiple Deposits with Interest
```
SavingsAccount with Balance: $1105, Interest Rate: 5%
→ Deposit $200 →
   - Deposit amount: $200
   - Interest earned: $200 × 0.05 = $10
   - Total added: $210
   - Final Balance: $1315 ✓
```

### Scenario 4: Withdrawal (No Interest on Withdrawal)
```
SavingsAccount with Balance: $1315, Interest Rate: 5%
→ Withdraw $100 →
   - Balance decreases by: $100 (no interest applied)
   - Final Balance: $1215 ✓
```

---

## Acceptance Criteria

### AC1: SavingsAccount Class Created
- [ ] `SavingsAccount` class exists and can be instantiated
- [ ] Class is public and properly named
- [ ] No compilation errors

### AC2: Inheritance Established
- [ ] `SavingsAccount` extends `BankAccount`
- [ ] Inherits `accountNumber` and `balance` fields
- [ ] Inherits `withdraw()` method from parent
- [ ] Has access to parent constructor via `super()`

### AC3: Interest Rate Field Implemented
- [ ] `interestRate` field exists (double type, private)
- [ ] Properly initialized in constructor
- [ ] Value represents decimal percentage (e.g., 0.05 = 5%)

### AC4: Constructor Implementation
- [ ] Constructor accepts `accountNumber`, `initialBalance`, and `interestRate` parameters
- [ ] Calls parent constructor with account details
- [ ] Initializes `interestRate` field
- [ ] Can be instantiated successfully with valid parameters

### AC5: Deposit Override Works
- [ ] `deposit()` method is overridden in SavingsAccount
- [ ] Calculates interest correctly: `interest = amount * interestRate`
- [ ] Adds both deposit and interest to balance: `balance += amount + interest`
- [ ] Balance updates reflect both deposit and interest
- [ ] Inherited withdraw method still works correctly

### AC6: Main Demo Runs Successfully
- [ ] Main method creates a SavingsAccount instance with interest rate
- [ ] Demonstrates deposit operation with interest calculation
- [ ] Displays original balance, deposit amount, interest earned, and final balance
- [ ] Shows at least one withdrawal to demonstrate inherited functionality
- [ ] Program runs without exceptions
- [ ] Console output clearly shows interest calculations

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
   - Console output shows SavingsAccount creation
   - Deposit operation shows interest amount added
   - Final balance reflects deposit + interest
   - Interest calculations are mathematically correct

3. **Test Scenarios** (Run These)
   - Create SavingsAccount with:
     - Account number: "SAV001"
     - Initial balance: $1000
     - Interest rate: 5% (0.05)
   - Deposit $100 → Verify:
     - Interest: $5
     - New balance: $1105
   - Deposit $200 → Verify:
     - Interest: $10
     - New balance: $1315
   - Withdraw $150 → Verify:
     - No interest on withdrawal
     - Final balance: $1165

4. **Edge Cases** (Should Handle Gracefully)
   - Interest rate of 0% → Deposit should not add interest
   - Very small interest rate (0.01 = 1%) → Should calculate correctly
   - Large interest rate (0.10 = 10%) → Should calculate correctly
   - Deposit then withdraw → Withdraw should use parent logic
   - Multiple consecutive deposits → Each should apply interest independently

---

## Reference to Main AI Spec

This feature implements the SavingsAccount specialization outlined in the **JavaOopExercises** project specification:
- **Feature Type**: Object-Oriented Programming Exercise
- **Core Concept**: Class inheritance and method overriding
- **Architecture Pattern**: Subclass extending parent class with specialized behavior
- **Testing**: Interest calculation and balance updates provide testable behavior

---

## Files & Location

- **This File**: `./ai/features/# 🤖 AI_FEATURE_OOP SavingsAccount.feature.md`
- **Implementation**: `SavingsAccount.java` (extends `BankAccount.java`)
- **Main Demo**: `Main.java` (Exercise 2 demonstrated in `main()` method)
