// The Strategy Design Pattern defines a family of algorithms,
// encapsulates each one, and makes them interchangeable.
// Strategy lets the algorithm vary independently from clients that use it.

// 1. Strategy Interface
// This defines the common interface for all supported algorithms/strategies.
interface PaymentStrategy {
    void pay(double amount);
}

// 2. Concrete Strategy A - Credit Card Payment
// Implements the strategy interface using a specific payment method.
class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(double amount) {
        // In a real-world scenario, this method would integrate with a Credit Card payment gateway.
        System.out.println("Paid " + amount + " using Credit Card.");
        System.out.println("Card Owner: " + name + " | Card Number: ****-****-****-" + cardNumber.substring(cardNumber.length() - 4));
    }
}

// 3. Concrete Strategy B - PayPal Payment
// Implements the strategy interface using PayPal.
class PayPalPayment implements PaymentStrategy {
    private String emailId;
    private String password;

    public PayPalPayment(String email, String password) {
        this.emailId = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        // In a real-world scenario, this method would integrate with PayPal API/SDK.
        System.out.println("Paid " + amount + " using PayPal.");
        System.out.println("Account Email: " + emailId);
    }
}

// 4. Concrete Strategy C - Bitcoin Payment
// Implements the strategy interface using Cryptocurrencies.
class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        // In a real-world scenario, this method would broadcast the transaction to the Blockchain network.
        System.out.println("Paid " + amount + " using Bitcoin.");
        System.out.println("Wallet Address: " + walletAddress);
    }
}

// 5. Context Class - ShoppingCart
// It maintains a reference to a Strategy object and delegates work to it rather than implementing it directly.
class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private double totalAmount;

    public ShoppingCart() {
        this.totalAmount = 0.0;
    }

    public void addAmount(double price) {
        this.totalAmount += price;
    }

    // Allows dynamic changing/switching of strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // The client/context delegates the payment task to the currently set concrete strategy
    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method before checking out.");
            return;
        }
        paymentStrategy.pay(totalAmount);
        totalAmount = 0.0; // Reset total amount after a successful payment
    }
}

// 6. Client / Main Demonstration Class
public class StrategyPattern {
    public static void main(String[] args) {
        // Create the context (Shopping Cart)
        ShoppingCart cart = new ShoppingCart();

        // User adds items to the cart
        cart.addAmount(250.50);
        cart.addAmount(749.50); // Total amount = 1000.00

        System.out.println("--- Scenario 1: User chooses Credit Card ---");
        // User dynamically selects Credit Card payment method at runtime
        cart.setPaymentStrategy(new CreditCardPayment(
            "Vansh Deep", 
            "1234567890123456", 
            "999", 
            "12/30"
        ));
        cart.checkout();
        System.out.println();

        // User adds more items to the cart
        cart.addAmount(450.00);
        cart.addAmount(50.00); // Total amount = 500.00

        System.out.println("--- Scenario 2: User switches to PayPal ---");
        // User dynamically switches to PayPal payment method at runtime
        cart.setPaymentStrategy(new PayPalPayment(
            "vanshdeep@example.com", 
            "securePassword123"
        ));
        cart.checkout();
        System.out.println();

        // User adds a premium item to the cart
        cart.addAmount(15000.00); // Total amount = 15000.00

        System.out.println("--- Scenario 3: User switches to Bitcoin ---");
        // User dynamically switches to Bitcoin payment method at runtime
        cart.setPaymentStrategy(new BitcoinPayment(
            "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"
        ));
        cart.checkout();
    }
}
