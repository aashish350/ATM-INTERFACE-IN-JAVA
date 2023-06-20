package atm;

import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountId;
    private double balance;
    private List<BankTransaction> transactions;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public List<BankTransaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new BankTransaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new BankTransaction("Withdrawal", amount));
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactions.add(new BankTransaction("Transfer to " + recipient.getAccountId(), -amount));
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}
