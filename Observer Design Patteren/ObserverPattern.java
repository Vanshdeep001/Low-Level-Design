// The Observer Design Pattern defines a one-to-many dependency between objects
// so that when one object (the Subject) changes state, all its dependents
// (Observers) are notified and updated automatically.

// Key Benefit: It promotes loose coupling — the Subject doesn't need to know
// the concrete classes of its Observers. New observers can be added at any time
// without modifying the Subject. This follows the Open/Closed Principle (OCP).

import java.util.ArrayList;
import java.util.List;

// 1. Observer Interface
// This defines the contract that all observers must implement.
// Whenever the subject's state changes, update() is called on every registered observer.
interface Observer {
    void update(String stockName, double price);
}

// 2. Subject Interface
// This defines the contract for the object being observed.
// It provides methods to register, remove, and notify observers.
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 3. Concrete Subject - StockMarket
// Maintains a list of observers and notifies them whenever a stock price changes.
// The subject does NOT know (or care) what the observers do with the data —
// it only knows they implement the Observer interface.
class StockMarket implements Subject {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("  [StockMarket] New observer registered. Total observers: " + observers.size());
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("  [StockMarket] Observer removed. Total observers: " + observers.size());
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    // When the stock price is updated, all registered observers are notified automatically.
    public void setStockPrice(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        System.out.println("\n  [StockMarket] " + stockName + " price updated to $" + String.format("%.2f", stockPrice));
        notifyObservers(); // Push notification to all observers
    }
}

// 4. Concrete Observer A - MobileAppDisplay
// Displays the stock update on a mobile app notification.
class MobileAppDisplay implements Observer {
    private String userName;

    public MobileAppDisplay(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("    [MobileApp - " + userName + "] Notification: "
                + stockName + " is now $" + String.format("%.2f", price));
    }
}

// 5. Concrete Observer B - EmailAlertSystem
// Sends an email alert when the stock price changes.
class EmailAlertSystem implements Observer {
    private String emailAddress;

    public EmailAlertSystem(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void update(String stockName, double price) {
        // In a real-world scenario, this method would integrate with an email service/SMTP server.
        System.out.println("    [EmailAlert - " + emailAddress + "] Email sent: "
                + stockName + " price changed to $" + String.format("%.2f", price));
    }
}

// 6. Concrete Observer C - WebDashboard
// Updates a live web dashboard with the latest stock information.
class WebDashboard implements Observer {
    private String dashboardName;

    public WebDashboard(String dashboardName) {
        this.dashboardName = dashboardName;
    }

    @Override
    public void update(String stockName, double price) {
        // In a real-world scenario, this would push data to a WebSocket or refresh a UI component.
        System.out.println("    [WebDashboard - " + dashboardName + "] Live update: "
                + stockName + " -> $" + String.format("%.2f", price));
    }
}

// 7. Client / Main Demonstration Class
public class ObserverPattern {
    public static void main(String[] args) {

        // -------------------------------------------------------------------
        // Create the Subject (Stock Market)
        // -------------------------------------------------------------------
        StockMarket stockMarket = new StockMarket();

        // -------------------------------------------------------------------
        // Create Observers (different display/alert systems)
        // -------------------------------------------------------------------
        Observer mobileApp = new MobileAppDisplay("Vansh Deep");
        Observer emailAlert = new EmailAlertSystem("vanshdeep@example.com");
        Observer webDashboard = new WebDashboard("Trading Dashboard");

        // -------------------------------------------------------------------
        // Scenario 1: Register observers and update stock price
        // All three observers should be notified.
        // -------------------------------------------------------------------
        System.out.println("--- Scenario 1: Register all observers & update stock ---");
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(emailAlert);
        stockMarket.registerObserver(webDashboard);

        stockMarket.setStockPrice("GOOGLE", 2850.75);

        // -------------------------------------------------------------------
        // Scenario 2: Another stock update — all observers notified again
        // -------------------------------------------------------------------
        System.out.println("\n--- Scenario 2: Another stock update ---");
        stockMarket.setStockPrice("APPLE", 178.32);

        // -------------------------------------------------------------------
        // Scenario 3: Remove an observer, then update
        // Only the remaining observers should be notified.
        // -------------------------------------------------------------------
        System.out.println("\n--- Scenario 3: Remove Email observer & update ---");
        stockMarket.removeObserver(emailAlert);

        stockMarket.setStockPrice("TESLA", 265.10);

        // -------------------------------------------------------------------
        // Scenario 4: Add a new observer at runtime
        // Demonstrates that new observers can subscribe dynamically without
        // modifying the Subject class — this is the power of Observer Pattern.
        // -------------------------------------------------------------------
        System.out.println("\n--- Scenario 4: Add a new Mobile observer at runtime ---");
        Observer anotherMobile = new MobileAppDisplay("New Investor");
        stockMarket.registerObserver(anotherMobile);

        stockMarket.setStockPrice("AMAZON", 3421.50);

        // -------------------------------------------------------------------
        // Notice: To add a completely new type of observer (e.g., SMSAlert),
        // we only need to:
        //   1. Create a new class 'SMSAlert implements Observer'
        //   2. Register it with stockMarket.registerObserver(new SMSAlert(...))
        // The Subject (StockMarket) code stays UNCHANGED — this is the power
        // of the Observer Pattern and the Open/Closed Principle.
        // -------------------------------------------------------------------
    }
}
