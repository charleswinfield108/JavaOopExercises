# 🤖 AI Feature Specification — OOP Interest

> This feature specification is part of the **JavaOopExercises** project.
> It defines interest rate management for SavingsAccount with dynamic rate updates.
> Reference the main **AI_SPEC** for project context and overall architecture.

---

## Feature Goal & Scope

### Feature Goal

Implement dynamic interest rate management for SavingsAccount, allowing customers to update their account's interest rate and have new deposits automatically use the updated rate for interest calculations.

### In Scope (Build Now)

- **Update Interest Rate Method**: Add updateInterestRate() to SavingsAccount
- **Dynamic Rate Changes**: Allow changing interest rate after account creation
- **New Deposits Use Updated Rate**: Subsequent deposits apply the new interest rate
- **Main Demo**: Console demonstration of changing interest rates and their effect on deposits

### Out of Scope (Do NOT Build)

- Interest rate history or audit trail
- Retroactive interest recalculation on existing balance
- Rate conversion or validation
- Multiple interest rate tiers
- Promotional rate changes
- Interest rate scheduling
- Rate comparison or optimization
- Account upgrade/downgrade based on rates

---

## Requirements Breakdown & User Flow

### Core Requirements

#### R1: Update Interest Rate Method
- Add `updateInterestRate(double newRate)` method to SavingsAccount class
- Method is public and returns void
- Accepts a double parameter representing the new interest rate (as decimal, e.g., 0.05 = 5%)
- Updates the existing interestRate field with the new value
- Method can be called multiple times throughout account lifetime

#### R2: Main Demo
- Demonstrate interest rate updates in `Main.main()` method
- Create a SavingsAccount with initial interest rate
- Perform a deposit with original interest rate
- Call updateInterestRate() to change the rate
- Perform another deposit with new interest rate
- Display transactions and balances showing both interest calculations
- Show clear before/after comparison of interest applied

### User Flow

```
1. Create SavingsAccount with interest rate (e.g., 5%)
   ↓
2. Deposit $100 with 5% interest
   → Interest: $100 × 0.05 = $5
   → Balance: $105
   ↓
3. Call updateInterestRate(0.10) to change to 10%
   → Interest rate updated
   ↓
4. Deposit $100 with new 10% interest
   → Interest: $100 × 0.10 = $10
   → Balance: $215
   ↓
5. Display comparison showing different interest calculations
```

---

## Interfaces Involved (Classes & Methods)

### SavingsAccount Class (Modified)

```java
public class SavingsAccount extends BankAccount {
    // Attributes
    private double interestRate;
    
    // Existing Methods
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate)
    public void deposit(double amount)
    
    // New Method
    public void updateInterestRate(double newRate)
}
```

---

## Data, Validations & Expected Behavior

### Data Structures

| Entity | Attribute | Type | Constraints |
|--------|-----------|------|-------------|
| SavingsAccount | interestRate | double | Updated dynamically, 0–1 (decimal) |

### Validation Rules

#### Update Interest Rate
- New rate is provided as decimal (0.05 = 5%)
- Rate can be any non-negative double value
- No upper limit on rate value
- Immediately takes effect for subsequent deposits
- Does NOT affect previous balance or transactions

#### Deposit After Rate Change
- Uses the CURRENT interestRate value
- Interest calculated on deposit amount only
- Formula: `interest = amount * currentInterestRate`
- Previous calculations unaffected

---

## Expected Behavior Scenarios

### Scenario 1: Initial Deposit with Original Rate
```
Account: SAV001
Initial Balance: $1000
Interest Rate: 5% (0.05)

→ Deposit $100
   - Interest: $100 × 0.05 = $5
   - New Balance: $1105 ✓
   - Subsequent Rate Change: 10%
```

### Scenario 2: Deposit After Rate Increase
```
Account: SAV001
Balance: $1105
Interest Rate: 10% (0.10) [updated]

→ Deposit $100
   - Interest: $100 × 0.10 = $10
   - New Balance: $1215 ✓
   - Previous balance ($1105) unaffected
```

### Scenario 3: Multiple Rate Changes
```
Account: SAV001
Initial Rate: 5%

→ Deposit $100 at 5%
   - Interest: $5
   - Balance: $1105

→ updateInterestRate(0.08)

→ Deposit $100 at 8%
   - Interest: $8
   - Balance: $1213

→ updateInterestRate(0.10)

→ Deposit $100 at 10%
   - Interest: $10
   - Balance: $1323 ✓

Total Balance: $1323
```

### Scenario 4: Rate Decrease
```
Account: SAV001
Interest Rate: 10% (0.10)

→ Deposit $100
   - Interest: $10
   - Balance: $1210

→ updateInterestRate(0.03) [rate decrease]

→ Deposit $100
   - Interest: $3 (lower interest with new rate)
   - Balance: $1313 ✓
```

### Scenario 5: Zero Interest Rate
```
Account: SAV001
Interest Rate: 5% (0.05)

→ Deposit $100
   - Interest: $5
   - Balance: $1105

→ updateInterestRate(0.00) [no interest]

→ Deposit $100
   - Interest: $0 (no interest applied)
   - Balance: $1205 ✓
```

---

## Acceptance Criteria

### AC1: Update Interest Rate Method Implemented
- [ ] `updateInterestRate(double newRate)` method exists in SavingsAccount
- [ ] Method is public and returns void
- [ ] Accepts a double parameter for new interest rate
- [ ] Updates the interestRate field correctly
- [ ] Can be called multiple times

### AC2: Rate Change Takes Effect Immediately
- [ ] After calling updateInterestRate(), the new rate is active
- [ ] Subsequent deposits use the new rate
- [ ] Previous balance is NOT recalculated with new rate
- [ ] Transaction history reflects correct interest at time of deposit

### AC3: Interest Calculation Uses Current Rate
- [ ] Deposits after rate change apply new interest correctly
- [ ] Interest formula: `interest = amount * newInterestRate`
- [ ] Multiple rate changes work correctly
- [ ] Rate can increase, decrease, or be set to zero

### AC4: Main Demo Runs Successfully
- [ ] Creates SavingsAccount with initial interest rate
- [ ] Performs deposit with original rate
- [ ] Calls updateInterestRate() to change rate
- [ ] Performs deposit with new rate
- [ ] Displays both deposits with correct interest calculations
- [ ] Shows clear comparison of original vs. updated interest
- [ ] Program runs without exceptions

### AC5: Integration with Transaction History
- [ ] Each deposit records transaction with correct interest amount
- [ ] Transaction history shows deposits at different rates
- [ ] Transactions can be retrieved and viewed in order

### AC6: Multiple Rate Changes Handled
- [ ] Can change rate multiple times
- [ ] Each change takes effect immediately
- [ ] All subsequent deposits use most recent rate
- [ ] Previous operations not affected

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
   - Console shows initial deposit with original interest
   - Interest amount clearly displayed
   - Shows rate change in output
   - Shows deposit with new interest amount
   - New interest is correctly calculated
   - Balances are accurate and updated

3. **Test Scenarios** (Run These)
   - Create SavingsAccount(SAV001, $1000, 0.05)
   - Deposit $100
   - Verify: Interest = $5, Balance = $1105
   
   - Call updateInterestRate(0.10)
   - Deposit $100
   - Verify: Interest = $10, Balance = $1215
   
   - Call updateInterestRate(0.03)
   - Deposit $100
   - Verify: Interest = $3, Balance = $1318

4. **Edge Cases** (Should Handle Gracefully)
   - Update rate to 0% → No interest on next deposit
   - Update to very high rate (e.g., 1.0 = 100%) → Interest calculated correctly
   - Update to very small rate (e.g., 0.001 = 0.1%) → Calculated correctly
   - Multiple rapid updates → Last update used for next deposit
   - Update then immediately deposit → New rate applied
   - getTransactionHistory() after updates → All interests recorded correctly

5. **Verification of Calculation**
   - Manually verify: Interest = deposit × rate
   - For $100 at 5%: should be $5 ✓
   - For $100 at 10%: should be $10 ✓
   - For $100 at 3%: should be $3 ✓

---

## Reference to Main AI Spec

This feature implements dynamic interest rate management outlined in the **JavaOopExercises** project specification:
- **Feature Type**: Object-Oriented Programming Exercise
- **Core Concept**: Mutable state management and dynamic behavior
- **Architecture Pattern**: State modification with immediate effect
- **Testing**: Multiple rate changes and interest calculations provide testable behavior

---

## Implementation Notes

- The updateInterestRate() method should directly update the interestRate field
- Interest calculation in deposit() should use the CURRENT value of interestRate
- Previous deposits and their interest amounts should NOT be affected by rate changes
- The method is simple but demonstrates important OOP concepts: encapsulation and state management
- If transaction history is enabled, each deposit should record the interest at time of deposit

---

## Files & Location

- **This File**: `./ai/features/# 🤖 AI_FEATURE_OOP Interest.feature.md`
- **Implementation**: Modified `SavingsAccount.java` (add updateInterestRate() method)
- **Main Demo**: `Main.java` (Exercise 2+ demonstrated in `main()` method)
