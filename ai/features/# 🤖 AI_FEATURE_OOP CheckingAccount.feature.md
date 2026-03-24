# 🤖 AI Feature Specification — OOP CheckingAccount

> This feature specification is part of the **JavaOopExercises** project.
> It defines the CheckingAccount class that extends BankAccount with overdraft protection.
> Reference the main **AI_SPEC** for project context and overall architecture.

---

## Feature Goal & Scope

### Feature Goal

Implement a CheckingAccount class that extends BankAccount to provide specialized account functionality with overdraft protection that allows withdrawals beyond the current balance up to a specified limit.

### In Scope (Build Now)

- **CheckingAccount Class**: Specialized account type for checking
- **Inheritance**: Extend BankAccount class
- **Overdraft Limit Field**: Store overdraft protection limit as a property
- **Constructor**: Initialize account details with overdraft limit
- **Withdraw Override**: Override parent withdraw method to allow overdraft within limit
- **Main Demo**: Console demonstration of CheckingAccount operations with overdraft

### Out of Scope (Do NOT Build)

- Overdraft fees or charges
- Overdraft notification system
- Multiple overdraft limits
- Account closure on excessive overdraft
- SavingsAccount or other account types
- Customer management or transaction history
- Persistent storage or file I/O
- User authentication

---

## Requirements Breakdown & User Flow

### Core Requirements

#### R1: Create CheckingAccount Class
- Define a new class named `CheckingAccount`
- Use public access modifier

#### R2: Extend BankAccount
- `CheckingAccount` must inherit from `BankAccount`
- Use `extends` keyword to establish inheritance relationship

#### R3: Add Overdraft Limit Field
- Add `overdraftLimit` field (double type)
- Store as private field
- Represents maximum negative balance allowed (e.g., $200 overdraft limit)

#### R4: Constructor With Overdraft
- Create a constructor that accepts `accountNumber`, `initialBalance`, and `overdraftLimit` parameters
- Call parent constructor with `accountNumber` and `initialBalance`
- Initialize the `overdraftLimit` field with provided value

#### R5: Override Withdraw Method
- Override the inherited `withdraw(double amount)` method
- Calculate available funds: `totalAvailable = balance + overdraftLimit`
- Allow withdrawal if: `(balance - amount) ≥ -overdraftLimit`
- Update balance: `balance -= amount` (balance can become negative)
- Reject withdrawal if it would exceed overdraft limit

#### R6: Main Demo
- Demonstrate CheckingAccount functionality in the `Main.main()` method
- Create a CheckingAccount instance with account number, initial balance, and overdraft limit
- Show successful withdrawal within overdraft limit
- Show attempted withdrawal exceeding overdraft limit (rejected)
- Display balance (including negative) using `System.out.println()`

### User Flow

```
1. User creates a CheckingAccount with account number, initial balance, and overdraft limit
   ↓
2. User performs withdrawal operations:
   a) Withdraw within balance → Balance decreases normally
   b) Withdraw more than balance but within overdraft limit → Balance goes negative (allowed)
   c) Withdraw exceeding overdraft limit → Operation rejected
   ↓
3. Results displayed in console showing:
   - Current balance (positive or negative)
   - Success/failure of withdrawals
   - Remaining overdraft protection available
```

---

## Interfaces Involved (Classes & Methods)

### CheckingAccount Class

```java
public class CheckingAccount extends BankAccount {
    // Attributes
    private double overdraftLimit;
    
    // Constructor
    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit)
    
    // Overridden Methods
    @Override
    public void withdraw(double amount)
}
```

---

## Data, Validations & Expected Behavior

### Data Structures

| Entity | Attribute | Type | Constraints |
|--------|-----------|------|-------------|
| CheckingAccount | accountNumber | String | Inherited from BankAccount |
| CheckingAccount | balance | double | Inherited from BankAccount, can be negative |
| CheckingAccount | overdraftLimit | double | ≥ 0, represents protection amount |

### Validation Rules

#### Withdraw with Overdraft Protection
- Amount must be positive (> 0)
- Total available funds: `totalAvailable = balance + overdraftLimit`
- Withdrawal allowed if: `(balance - amount) ≥ -overdraftLimit`
- Equivalent check: `amount ≤ (balance + overdraftLimit)`
- If valid: `balance -= amount` (balance can go negative)
- If invalid: reject operation, balance unchanged
- Negative balance is normal and allowed

#### Inherited Deposit
- Deposit uses parent BankAccount logic
- No special handling for overdraft
- Increases balance normally

---

## Expected Behavior Scenarios

### Scenario 1: Checking Account Creation
```
Account: CHK001
Initial Balance: $500
Overdraft Limit: $200
Total Available: $500 + $200 = $700
```

### Scenario 2: Withdrawal Within Balance
```
CheckingAccount: Balance $500, Overdraft $200
→ Withdraw $300 →
   - Amount ≤ Balance ✓
   - Balance: $500 - $300 = $200 ✓
```

### Scenario 3: Withdrawal Using Overdraft Protection
```
CheckingAccount: Balance $200, Overdraft $200
→ Withdraw $250 →
   - Amount ≤ (Balance + Overdraft) = $450 ✓
   - Balance: $200 - $250 = -$50 ✓
   - Overdraft used: $50 out of $200 allowed
```

### Scenario 4: Withdrawal Exceeding Overdraft Limit
```
CheckingAccount: Balance $200, Overdraft $200
→ Withdraw $450 →
   - Amount > (Balance + Overdraft) = $450 ✗
   - Would result in: $200 - $450 = -$250
   - Exceeds overdraft limit of $200 ✗
   - Operation REJECTED, Balance remains: $200 ✓
```

### Scenario 5: Overdraft at Maximum
```
CheckingAccount: Balance $500, Overdraft $200
→ Withdraw $700 →
   - Amount = (Balance + Overdraft) ✓
   - Balance: $500 - $700 = -$200 ✓
   - Overdraft fully used, at limit
```

### Scenario 6: Deposit Reducing Overdraft
```
CheckingAccount: Balance -$100, Overdraft $200
→ Deposit $150 →
   - Balance: -$100 + $150 = $50 ✓
   - No longer in overdraft
```

---

## Acceptance Criteria

### AC1: CheckingAccount Class Created
- [ ] `CheckingAccount` class exists and can be instantiated
- [ ] Class is public and properly named
- [ ] No compilation errors

### AC2: Inheritance Established
- [ ] `CheckingAccount` extends `BankAccount`
- [ ] Inherits `accountNumber` and `balance` fields
- [ ] Inherits `deposit()` method from parent
- [ ] Has access to parent constructor via `super()`

### AC3: Overdraft Limit Field Implemented
- [ ] `overdraftLimit` field exists (double type, private)
- [ ] Properly initialized in constructor
- [ ] Value represents the maximum negative balance allowed

### AC4: Constructor Implementation
- [ ] Constructor accepts `accountNumber`, `initialBalance`, and `overdraftLimit` parameters
- [ ] Calls parent constructor with account details
- [ ] Initializes `overdraftLimit` field
- [ ] Can be instantiated successfully with valid parameters

### AC5: Withdraw Override Works
- [ ] `withdraw()` method is overridden in CheckingAccount
- [ ] Allows withdrawal if `(balance - amount) ≥ -overdraftLimit`
- [ ] Rejects withdrawal if it would violate overdraft limit
- [ ] Balance can go negative (but not beyond overdraft limit)
- [ ] Inherited deposit method still works correctly

### AC6: Main Demo Runs Successfully
- [ ] Main method creates a CheckingAccount instance with overdraft limit
- [ ] Demonstrates withdrawal within balance
- [ ] Demonstrates withdrawal using overdraft protection (negative balance)
- [ ] Demonstrates attempted withdrawal exceeding overdraft limit (rejected)
- [ ] Displays balance including negative values
- [ ] Program runs without exceptions
- [ ] Console output clearly shows success/failure of operations

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
   - Console output shows CheckingAccount creation
   - Withdrawal operations show success/failure clearly
   - Negative balances are displayed correctly
   - Overdraft limit is respected

3. **Test Scenarios** (Run These)
   - Create CheckingAccount with:
     - Account number: "CHK001"
     - Initial balance: $500
     - Overdraft limit: $200
   - Withdraw $300 → Verify:
     - Success ✓
     - Balance: $200
   - Withdraw $250 → Verify:
     - Success ✓ (uses overdraft)
     - Balance: -$50
   - Try to withdraw $300 → Verify:
     - Failure ✗ (exceeds overdraft limit)
     - Balance still: -$50
   - Deposit $100 → Verify:
     - Success ✓
     - Balance: $50

4. **Edge Cases** (Should Handle Gracefully)
   - Overdraft limit of $0 → No overdraft allowed, acts like regular account
   - Withdraw exactly the overdraft limit from $0 balance → Should succeed
   - Withdraw more than overdraft limit → Should fail
   - Balance at exactly -overdraftLimit → Try to withdraw more → Should fail
   - Deposit into negative balance → Correctly increases balance
   - Multiple withdrawals using overdraft → All tracked correctly

---

## Reference to Main AI Spec

This feature implements the CheckingAccount specialization outlined in the **JavaOopExercises** project specification:
- **Feature Type**: Object-Oriented Programming Exercise
- **Core Concept**: Class inheritance and method overriding with advanced validation
- **Architecture Pattern**: Subclass extending parent class with specialized behavior and constraints
- **Testing**: Overdraft validation and balance management provide complex testable behavior

---

## Files & Location

- **This File**: `./ai/features/# 🤖 AI_FEATURE_OOP CheckingAccount.feature.md`
- **Implementation**: `CheckingAccount.java` (extends `BankAccount.java`)
- **Main Demo**: `Main.java` (Exercise 3 demonstrated in `main()` method)
