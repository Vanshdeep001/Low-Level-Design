package Polymorphism;

class Payment {
    private String payerName;
    private double amount;

    public Payment(String payerName, double amount) {
        this.payerName = payerName;
        this.amount = amount;
    }

    public String getPayerName() {
        return payerName;
    }

    public double getAmount() {
        return amount;
    }

    public void processPayment() {
        System.out.println("Processing payment of " + amount + " by " + payerName);
    }

    public void displayInfo() {
        System.out.println("Payer: " + payerName);
        System.out.println("Amount: " + amount);
    }
}

class CreditCardPayment extends Payment {
    private String cardNumber;
    private String bankName;

    public CreditCardPayment(String payerName, double amount, String cardNumber, String bankName) {
        super(payerName, amount);
        this.cardNumber = cardNumber;
        this.bankName = bankName;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of " + getAmount() + " by " + getPayerName());
        System.out.println("Card ending: " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Bank: " + bankName);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Payment Method: Credit Card");
        System.out.println("Bank: " + bankName);
    }
}

class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String payerName, double amount, String upiId) {
        super(payerName, amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment of " + getAmount() + " by " + getPayerName());
        System.out.println("UPI ID: " + upiId);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Payment Method: UPI");
        System.out.println("UPI ID: " + upiId);
    }
}

class NetBankingPayment extends Payment {
    private String bankName;
    private String accountNumber;

    public NetBankingPayment(String payerName, double amount, String bankName, String accountNumber) {
        super(payerName, amount);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing net banking payment of " + getAmount() + " by " + getPayerName());
        System.out.println("Bank: " + bankName);
        System.out.println("Account ending: " + accountNumber.substring(accountNumber.length() - 4));
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Payment Method: Net Banking");
        System.out.println("Bank: " + bankName);
    }
}

public class polymorphism2 {
    public static void main(String[] args) {
        Payment[] payments = {
            new CreditCardPayment("Rahul Sharma", 5000, "4111111111111234", "HDFC"),
            new UPIPayment("Priya Singh", 1500, "priya@okicici"),
            new NetBankingPayment("Amit Kumar", 3000, "SBI", "9876543210")
        };

        for (Payment p : payments) {
            p.displayInfo();
            p.processPayment();
            System.out.println("---");
        }
    }
}