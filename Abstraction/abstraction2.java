package Abstraction;

interface Payable {
    boolean processPayment(double amount);
    String getPaymentMethod();
}

interface Notifiable {
    void sendConfirmation(String recipient, String message);
}

class CreditCardProcessor implements Payable {
    private String cardNumber;

    public CreditCardProcessor(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Charging $%.2f to card ending %s%n",
                amount, cardNumber.substring(cardNumber.length() - 4));
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}

class SMSNotifier implements Notifiable {
    @Override
    public void sendConfirmation(String recipient, String message) {
        System.out.printf("SMS to %s: %s%n", recipient, message);
    }
}

class OrderService {
    private final Payable paymentProcessor;
    private final Notifiable notifier;

    public OrderService(Payable paymentProcessor, Notifiable notifier) {
        this.paymentProcessor = paymentProcessor;
        this.notifier          = notifier;
    }

    public void placeOrder(String customerPhone, double amount) {
        boolean paid = paymentProcessor.processPayment(amount);
        if (paid) {
            notifier.sendConfirmation(customerPhone,
                    "Order confirmed! Payment via " + paymentProcessor.getPaymentMethod());
        }
    }
}

public class abstraction2 {
    public static void main(String[] args) {
        Payable    processor = new CreditCardProcessor("4111111111111234");
        Notifiable notifier  = new SMSNotifier();

        OrderService service = new OrderService(processor, notifier);
        service.placeOrder("+91-9999999999", 1499.00);
    }
}