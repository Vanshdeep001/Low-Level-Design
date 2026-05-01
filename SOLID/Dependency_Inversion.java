package SOLID;

// high level classes should not depend on low level classes
// both should depend on abstractions (interfaces)

// abstraction — high level and low level both depend on this
interface MessageSender {
    void sendMessage(String message);
}

// low level class 1
class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// low level class 2
class SMSSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// low level class 3
class PushNotificationSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

// high level class — depends on the interface, not on any specific sender
class NotificationManager {
    private MessageSender sender;

    // sender is injected from outside — easy to swap without changing this class
    public NotificationManager(MessageSender sender) {
        this.sender = sender;
    }

    public void notify(String message) {
        sender.sendMessage(message);
    }
}

public class Dependency_Inversion {
    public static void main(String[] args) {
        // swap the sender without touching NotificationManager
        NotificationManager emailNotification = new NotificationManager(new EmailSender());
        emailNotification.notify("Your order has been placed");
        System.out.println("---");

        NotificationManager smsNotification = new NotificationManager(new SMSSender());
        smsNotification.notify("Your OTP is 1234");
        System.out.println("---");

        NotificationManager pushNotification = new NotificationManager(new PushNotificationSender());
        pushNotification.notify("You have a new message");
    }
}