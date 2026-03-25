# 🏦 JavaOopExercises

## 📋 Project Description

**JavaOopExercises** is an educational project designed to teach and practice Object-Oriented Programming (OOP) concepts in Java. The project simulates a banking system with progressive complexity, implementing core OOP principles including encapsulation, inheritance, polymorphism, and composition.

Through 8 comprehensive exercises, learners build a hierarchy of banking classes from basic account management to advanced features like transaction history tracking, interest calculations, and overdraft protection.

---

## 🛠️ Tech Stack

| Category | Technology |
|----------|-----------|
| **Language** | Java 8+ |
| **Build System** | Native Java Compiler (`javac`) |
| **IDE Recommended** | VS Code with Extension Pack for Java |
| **Runtime** | Java Virtual Machine (JVM) |
| **Version Control** | Git |

---

## 📁 Project Structure

```
JavaOopExercises/
├── README.md                          # Project documentation
├── Main.java                          # Main entry point with all exercise demos
├── Person.java                        # Example class (Exercise 0)
├── BankAccount.java                   # Exercise 1: Basic bank account
├── SavingsAccount.java                # Exercise 2: Savings account with interest
├── CheckingAccount.java               # Exercise 3: Checking account with overdraft
├── BankCustomer.java                  # Exercise 4: Customer account management
├── ai/                                # AI-generated specifications
│   └── features/                      # Feature specifications for each exercise
│       ├── # 🤖 AI_FEATURE_OOP Bank Account.feature.md
│       ├── # 🤖 AI_FEATURE_OOP SavingsAccount.feature.md
│       ├── # 🤖 AI_FEATURE_OOP CheckingAccount.feature.md
│       ├── # 🤖 AI_FEATURE_OOP BankCustomer.feature.md
│       ├── # 🤖 AI_FEATURE_OOP Extend BankAccount.feature.md
│       ├── # 🤖 AI_FEATURE_OOP Interest.feature.md
│       ├── # 🤖 AI_FEATURE_OOP Report.feature.md
│       └── # 🤖 AI_FEATURE_OOP Limits.feature.md
├── .git/                              # Git repository
└── .gitignore                         # Git ignore configuration
```

---

## 🚀 Installation / Setup Instructions

### Prerequisites
- **Java Development Kit (JDK)**: Java 8 or higher installed
- **Git**: For version control (optional but recommended)
- **VS Code**: For development (optional; any text editor works)

### Step-by-Step Setup

#### 1️⃣ Clone the Repository
```bash
git clone https://github.com/charleswinfield108/JavaOopExercises.git
cd JavaOopExercises
```

#### 2️⃣ Verify Java Installation
```bash
java -version
javac -version
```

#### 3️⃣ Compile All Java Files
```bash
javac *.java
```

#### 4️⃣ Run the Program
```bash
java Main
```

#### Expected Output
The program will display demonstrations of all 8 exercises with account operations, transaction histories, and calculations.

### Optional: IDE Setup (VS Code)

1. Install **Extension Pack for Java** from VS Code marketplace
2. Open the project folder in VS Code
3. The IDE will automatically detect Java files and compile settings
4. Click "Run" button to execute, or use terminal commands above

---

## 🔐 Environment Variables

**❌ Not Applicable** — This project does not require environment variables.

The application is self-contained and does not interact with external services, databases, or APIs that would require configuration through environment variables.

---

## 📚 API Documentation

**❌ Not Applicable** — This is not a web service or REST API.

This is an educational Java application focused on OOP concepts. However, here's an overview of the **public class interfaces**:

### BankAccount
```java
public BankAccount(String accountNumber, double initialBalance)
public void deposit(double amount)
public void withdraw(double amount)
public double getBalance()
public String getAccountNumber()
public List<String> getTransactionHistory()
```

### SavingsAccount (extends BankAccount)
```java
public SavingsAccount(String accountNumber, double initialBalance, double interestRate)
@Override public void deposit(double amount)  // Adds interest
public double getInterestRate()
public void updateInterestRate(double newRate)
```

### CheckingAccount (extends BankAccount)
```java
public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit)
@Override public void withdraw(double amount)  // Allows overdraft
public double getOverdraftLimit()
```

### BankCustomer
```java
public BankCustomer(String name)
public void addAccount(BankAccount account)
public double totalBalance()
public String getName()
public List<BankAccount> getAccounts()
```

---

## ‍💻 Author

**Charles Winfield**
- GitHub: [@charleswinfield108](https://github.com/charleswinfield108)
- Repository: [JavaOopExercises](https://github.com/charleswinfield108/JavaOopExercises)
