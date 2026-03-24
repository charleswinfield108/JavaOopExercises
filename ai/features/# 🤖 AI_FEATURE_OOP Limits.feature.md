# 🤖 AI Feature Specification — OOP Limits

> This feature specification is part of the **JavaOopExercises** project.
> It defines withdrawal validation and overdraft limit enforcement for CheckingAccount.
> Reference the main **AI_SPEC** for project context and overall architecture.

---

## Feature Goal & Scope

### Feature Goal

Implement withdrawal validation logic in CheckingAccount to enforce overdraft limits, preventing withdrawals that would exceed the account's total available funds (balance + overdraftLimit).

### In Scope (Build Now)

- **Override Withdraw Method**: Implement withdraw() in CheckingAccount with validation
- **Overdraft Limit Enforcement**: Validate that withdrawal does not exceed balance + overdraftLimit
- **Rejection Logic**: Deny withdrawal operations that violate the limit
- **Balance Preservation**: Ensure balance remains unchanged for rejected withdrawals
- **Main Demo**: Demonstrate successful withdrawal and rejection scenarios

### Out of Scope (Do NOT Build)

- Overdraft fees or penalties
- Overdraft notifications or alerts
- Withdrawal cancellation or reversal
- Partial approval of withdrawals
- Alternative payment methods when limit exceeded
- Overdraft recovery procedures
- Step-by-step withdrawal processes
- Multiple rejection reasons

---

## Requirements Breakdown & User Flow

### Core Requirements

#### R1: Override Withdraw With Restriction
- Override the `withdraw(double amount)` method in CheckingAccount class
- Inherit from BankAccount but add specialized validation
- Check if withdrawal would exceed overdraft limit before processing
- Use parent class deposit/withdraw constraints as baseline

#### R2: Prevent Over-Limit Withdrawal
- Calculate total available funds: `totalAvailable = balance + overdraftLimit`
- Validate that withdrawal does not exceed total available
- Formula: withdrawal is allowed if `amount ≤ (balance + overdraftLimit)`
- Equivalently: withdrawal is **rejected** if `amount > (balance + overdraftLimit)`
- If valid: decrease balance (can go negative up to -overdraftLimit)
- If invalid: reject operation, do NOT modify balance, do NOT record transaction

#### R3: Main Demo
- Demonstrate overdraft restriction in `Main.main()` method
- Create CheckingAccount with specific balance and overdraft limit
- Attempt withdrawal within limit → Should succeed
- Attempt withdrawal exceeding limit → Should fail
- Show clear success/failure messages
- Display final balance after all operations

### User Flow

```
1. Create CheckingAccount(account#, balance, overdraftLimit)
   ↓
2. Attempt Withdrawal #1 (within limit)
   → Validate: amount ≤ (balance + overdraftLimit) ✓
   → Process: balance -= amount
   → Success message displayed
   ↓
3. Attempt Withdrawal #2 (exceeding limit)
   → Validate: amount > (balance + overdraftLimit) ✗
   → Reject: do NOT update balance
   → Failure message displayed
   ↓
4. Display Final Balance
   → Shows balance after valid operations only
```

---

## Interfaces Involved (Classes & Methods)

### CheckingAccount Class (Override Method)

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

### Validation Logic Pseudocode

```java
@Override
public void withdraw(double amount) {
    // Validate amount is positive
    if (amount <= 0) {
        // Handle invalid amount
        return;
    }
    
    // Calculate total available funds
    double totalAvailable = getBalance() + overdraftLimit;
    
    // Check if withdrawal exceeds limit
    if (amount > totalAvailable) {
        // Withdrawal rejected - exceeds overdraft limit
        return;
    }
    
    // Withdrawal approved - process it
    // Update balance (can go negative)
    // Record transaction
}
```

---

## Data, Validations & Expected Behavior

### Data Structures

| Entity | Attribute | Type | Purpose |
|--------|-----------|------|---------|
| CheckingAccount | balance | double | Current account balance (inherited) |
| CheckingAccount | overdraftLimit | double | Maximum negative balance allowed |

### Validation Rules

#### Withdrawal Validation Check
- **Amount Validation**: amount must be > 0
- **Overdraft Validation**: `amount ≤ (balance + overdraftLimit)`
- **Calculation**: totalAvailable = balance + overdraftLimit
- **Decision**: 
  - If `amount ≤ totalAvailable` → **ALLOW** withdrawal
  - If `amount > totalAvailable` → **DENY** withdrawal

#### On Valid Withdrawal
- Decrease balance: `balance -= amount`
- Record transaction: "Withdraw: -$amount"
- Display success message

#### On Invalid Withdrawal
- Balance remains unchanged
- No transaction recorded
- Display rejection message
- Return control to caller

### Limit Scenarios

| Scenario | Balance | Limit | Request | Result | New Balance |
|----------|---------|-------|---------|--------|-------------|
| Normal withdrawal | $500 | $200 | $300 | ✓ Allow | $200 |
| Using some overdraft | $500 | $200 | $600 | ✓ Allow | -$100 |
| At overdraft limit | $500 | $200 | $700 | ✓ Allow | -$200 |
| Exceeding limit | $500 | $200 | $750 | ✗ Deny | $500 |
| Zero overdraft limit | $500 | $0 | $600 | ✗ Deny | $500 |
| Exact limit withdrawal | $100 | $200 | $300 | ✓ Allow | -$200 |

---

## Expected Behavior Scenarios

### Scenario 1: Normal Withdrawal (Within Balance)
```
Account: CHK001
Balance: $500, Overdraft Limit: $200
Total Available: $700

→ Withdraw $300
   - Amount ≤ Total Available ($300 ≤ $700) ✓
   - Operation: Allowed
   - New Balance: $200 ✓
   - Message: "Withdrawal successful. New balance: $200"
```

### Scenario 2: Withdrawal Using Overdraft
```
Account: CHK001
Balance: $200, Overdraft Limit: $200
Total Available: $400

→ Withdraw $300
   - Amount ≤ Total Available ($300 ≤ $400) ✓
   - Operation: Allowed
   - New Balance: -$100 ✓
   - Message: "Withdrawal successful. New balance: -$100 (overdraft)"
```

### Scenario 3: Withdrawal at Exact Overdraft Limit
```
Account: CHK001
Balance: $100, Overdraft Limit: $200
Total Available: $300

→ Withdraw $300
   - Amount ≤ Total Available ($300 ≤ $300) ✓
   - Operation: Allowed
   - New Balance: -$200 ✓ (at limit)
   - Message: "Withdrawal successful. New balance: -$200 (at overdraft limit)"
```

### Scenario 4: Withdrawal Exceeding Overdraft Limit
```
Account: CHK001
Balance: $100, Overdraft Limit: $200
Total Available: $300

→ Withdraw $350
   - Amount > Total Available ($350 > $300) ✗
   - Operation: Denied
   - Balance Unchanged: $100 ✓
   - Message: "Withdrawal denied. Insufficient funds (overdraft limit exceeded)."
```

### Scenario 5: Multiple Withdrawal Attempts
```
Account: CHK001
Balance: $500, Overdraft Limit: $200

→ Withdraw $400
   - Total Available: $700
   - $400 ≤ $700 ✓ Allowed
   - New Balance: $100

→ Withdraw $150
   - Total Available: $300 (updated from new balance)
   - $150 ≤ $300 ✓ Allowed
   - New Balance: -$50

→ Withdraw $200
   - Total Available: $150 (updated from new balance)
   - $200 > $150 ✗ Denied
   - Balance Unchanged: -$50 ✓

Final Balance: -$50
```

### Scenario 6: Zero Overdraft Limit
```
Account: CHK001
Balance: $500, Overdraft Limit: $0
Total Available: $500

→ Withdraw $400
   - $400 ≤ $500 ✓ Allowed
   - New Balance: $100

→ Withdraw $150
   - $150 > $100 ✗ Denied (no overdraft protection)
   - Balance Unchanged: $100 ✓
```

---

## Acceptance Criteria

### AC1: Withdraw Override Implemented
- [ ] `withdraw(double amount)` method overridden in CheckingAccount
- [ ] Method signature matches parent class
- [ ] Uses `@Override` annotation
- [ ] Receives amount parameter correctly

### AC2: Validation Logic Implemented
- [ ] Calculates total available: `total = balance + overdraftLimit`
- [ ] Checks if `amount ≤ totalAvailable`
- [ ] Allows withdrawal if check passes
- [ ] Denies withdrawal if check fails
- [ ] No balance modification on rejection

### AC3: Successful Withdrawal Processing
- [ ] Valid withdrawals update balance: `balance -= amount`
- [ ] Transaction is recorded (if transaction tracking enabled)
- [ ] Success message displayed to user
- [ ] Balance can go negative (up to -overdraftLimit)

### AC4: Rejected Withdrawal Handling
- [ ] Invalid withdrawals are rejected
- [ ] Balance remains unchanged
- [ ] No transaction recorded for failed withdrawal
- [ ] Clear error/rejection message displayed
- [ ] Method returns cleanly without exception

### AC5: Limit Enforcement
- [ ] Withdrawal at exact limit is allowed
- [ ] Withdrawal exceeding limit by $0.01 is denied
- [ ] Overdraft limit of $0 prevents all overdrafts
- [ ] Multiple limits are enforced correctly
- [ ] Limit validation works after deposits and withdrawals

### AC6: Main Demo Runs Successfully
- [ ] Demo creates CheckingAccount with specific limit
- [ ] Demonstrates at least one valid withdrawal
- [ ] Demonstrates at least one rejected withdrawal
- [ ] Shows clear messages for each outcome
- [ ] Displays final balance correctly
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
   - Console shows both successful and rejected withdrawals
   - Messages clearly indicate success or failure
   - Balance updates only for successful withdrawals
   - Rejected withdrawals preserve balance

3. **Test Scenarios** (Run These)
   - Create CheckingAccount("CHK001", $500, $200)
   
   - Test 1: Withdraw $300 (within balance)
     - Expected: Success ✓
     - Balance: $200
   
   - Test 2: Withdraw $250 (uses overdraft)
     - Expected: Success ✓
     - Balance: -$50
   
   - Test 3: Withdraw $200 (exceeds limit)
     - Expected: Denied ✗
     - Balance: -$50 (unchanged)
   
   - Test 4: Deposit $100, then withdraw $100
     - Expected: Both succeed ✓
     - Balance: $50

4. **Boundary Testing** (Critical Cases)
   - Withdraw amount = balance + overdraftLimit
     - Expected: Succeed ✓ (boundary case allows)
   
   - Withdraw amount = balance + overdraftLimit + $0.01
     - Expected: Denied ✗ (exceeds by tiny amount)
   
   - Zero overdraft limit
     - Withdraw = balance
     - Expected: Succeed ✓
     - Then try to withdraw again
     - Expected: Denied ✗
   
   - Negative amount
     - Expected: Handled (rejected or ignored)

5. **Edge Cases** (Should Handle Gracefully)
   - Withdraw $0 → Allowed or rejected (implementation dependent)
   - Very large withdrawal (10x overdraft) → Clearly denied
   - Balance = $0, limit = $200, withdraw $200 → Allowed
   - Balance = -$200, try to withdraw $1 → Denied
   - Multiple consecutive rejections → Handled correctly

---

## Reference to Main AI Spec

This feature implements the withdrawal restriction enforcement outlined in the **JavaOopExercises** project specification:
- **Feature Type**: Object-Oriented Programming Exercise
- **Core Concept**: Method overriding with enhanced validation
- **Architecture Pattern**: Template method pattern with business rule enforcement
- **Testing**: Boundary validation and limit enforcement provide complex testable behavior

---

## Implementation Notes

- The overdraft limit is a boundary that should NOT be exceeded
- Balance can equal -overdraftLimit, but NOT go below it
- The validation should happen BEFORE any balance modification
- Consider using explicit error messages or return values to indicate rejection
- Guard clauses can simplify the validation logic
- The reject case should be the first check for clarity

---

## Files & Location

- **This File**: `./ai/features/# 🤖 AI_FEATURE_OOP Limits.feature.md`
- **Implementation**: Modified `CheckingAccount.java` (enhance withdraw() validation)
- **Main Demo**: `Main.java` (Exercise 3+ demonstrated in `main()` method)
