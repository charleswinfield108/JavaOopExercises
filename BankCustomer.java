import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private List<BankAccount> accounts;

    public BankCustomer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account " + account.getAccountNumber() + " added for " + name);
    }

    public double totalBalance() {
        double total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void displayAccounts() {
        System.out.println("\n--- Accounts for " + name + " ---");
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getAccountNumber() + ", Balance: $" + account.getBalance());
        }
        System.out.println("Total Balance: $" + totalBalance());
    }
}
