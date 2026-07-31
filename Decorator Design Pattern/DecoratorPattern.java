// The Decorator Design Pattern allows behavior to be added to an individual object,
// dynamically at runtime, without affecting the behavior of other objects from the same class.
//
// Key Benefit: It provides a flexible alternative to subclassing for extending functionality.
// Instead of creating a huge hierarchy of subclasses (e.g. CoffeeWithMilk, CoffeeWithMilkAndSugar, etc.),
// decorators wrap the original component dynamically.
// This adheres to the Single Responsibility Principle (SRP) and Open/Closed Principle (OCP).

// 1. Component Interface
// Defines the interface for objects that can have responsibilities added to them dynamically.
interface Coffee {
    String getDescription();
    double getCost();
}

// 2. Concrete Component A - PlainCoffee
// The base object that can be decorated with additional add-ons/toppings.
class PlainCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    @Override
    public double getCost() {
        return 2.00; // Base price for plain coffee
    }
}

// Concrete Component B - Espresso
// Another base object option.
class Espresso implements Coffee {
    @Override
    public String getDescription() {
        return "Espresso Shot";
    }

    @Override
    public double getCost() {
        return 2.50; // Base price for espresso shot
    }
}

// 3. Abstract Decorator Class
// Implements the Component interface and holds a reference (composition) to a Component object.
// It delegates all operations to the wrapped component.
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// 4. Concrete Decorator A - MilkDecorator
// Adds milk to the coffee beverage.
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.50; // Additional $0.50 for milk
    }
}

// Concrete Decorator B - SugarDecorator
// Adds sugar to the coffee beverage.
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.20; // Additional $0.20 for sugar
    }
}

// Concrete Decorator C - WhippedCreamDecorator
// Adds whipped cream to the coffee beverage.
class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.75; // Additional $0.75 for whipped cream
    }
}

// Concrete Decorator D - CaramelDecorator
// Adds caramel syrup to the coffee beverage.
class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Caramel Syrup";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.90; // Additional $0.90 for caramel syrup
    }
}

// 5. Main Class to Demonstrate Decorator Pattern
public class DecoratorPattern {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            DECORATOR DESIGN PATTERN              ");
        System.out.println("==================================================\n");

        // Order 1: Simple Plain Coffee with no add-ons
        System.out.println("--- Order 1: Base Component ---");
        Coffee order1 = new PlainCoffee();
        printOrder(order1);

        // Order 2: Plain Coffee + Milk + Sugar
        System.out.println("\n--- Order 2: Plain Coffee + Milk + Sugar ---");
        Coffee order2 = new PlainCoffee();
        order2 = new MilkDecorator(order2);
        order2 = new SugarDecorator(order2);
        printOrder(order2);

        // Order 3: Fancy Custom Coffee (Espresso + Milk + Caramel + Whipped Cream)
        System.out.println("\n--- Order 3: Espresso + Milk + Caramel Syrup + Whipped Cream ---");
        Coffee order3 = new Espresso();
        order3 = new MilkDecorator(order3);
        order3 = new CaramelDecorator(order3);
        order3 = new WhippedCreamDecorator(order3);
        printOrder(order3);

        // Order 4: Double Milk Coffee (Demonstrating stacking same decorator)
        System.out.println("\n--- Order 4: Plain Coffee + Double Milk + Sugar ---");
        Coffee order4 = new PlainCoffee();
        order4 = new MilkDecorator(order4); // First shot of milk
        order4 = new MilkDecorator(order4); // Second shot of milk
        order4 = new SugarDecorator(order4);
        printOrder(order4);

        System.out.println("\n==================================================");
        System.out.println(" Key Takeaways:");
        System.out.println(" 1. Functionality added dynamically at runtime.");
        System.out.println(" 2. Avoids class explosion of endless combinations.");
        System.out.println(" 3. Decorators can be chained recursively.");
        System.out.println("==================================================");
    }

    private static void printOrder(Coffee coffee) {
        System.out.println("Description : " + coffee.getDescription());
        System.out.println("Total Cost  : $" + String.format("%.2f", coffee.getCost()));
    }
}
