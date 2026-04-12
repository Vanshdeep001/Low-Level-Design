package Encapsulation;

class BankAccount {
    private String accountHolder;
    private double balance;
    private String accountNumber;

    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds");
        }
    }

    public void displayInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class encapsulation1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Rahul Sharma", "SBI123456", 5000);

        account.displayInfo();
        System.out.println("---");

        account.deposit(2000);
        System.out.println("Balance after deposit: " + account.getBalance());
        System.out.println("---");

        account.withdraw(1500);
        System.out.println("Balance after withdrawal: " + account.getBalance());
        System.out.println("---");

        account.withdraw(99999);
    }
}