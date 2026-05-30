// The Factory Design Pattern defines an interface for creating objects,
// but lets subclasses or a factory method decide which class to instantiate.
// Factory Method lets a class defer instantiation to subclasses / a dedicated factory.

// Key Benefit: The client code is decoupled from the concrete classes it needs to create.
// Adding a new type requires NO changes in the client code — only a new class and
// a small update in the factory. This follows the Open/Closed Principle (OCP).

// 1. Product Interface
// This defines the common interface for all objects the factory will create.
interface Shape {
    void draw();
    double area();
}

// 2. Concrete Product A - Circle
// Implements the product interface for a specific shape.
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// 3. Concrete Product B - Rectangle
// Implements the product interface for a rectangular shape.
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle of " + width + " x " + height);
    }

    @Override
    public double area() {
        return width * height;
    }
}

// 4. Concrete Product C - Triangle
// Implements the product interface for a triangular shape.
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle with base " + base + " and height " + height);
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// 5. Factory Class - ShapeFactory
// The factory encapsulates the object creation logic.
// The client simply asks the factory for a shape by type, without knowing
// how the concrete object is constructed. This is the core of the pattern.
class ShapeFactory {

    // Factory Method — returns a Shape based on the given type string.
    // The client never uses 'new Circle(...)' etc. directly; it always goes through this method.
    public static Shape createShape(String shapeType, double... dimensions) {
        if (shapeType == null) {
            throw new IllegalArgumentException("Shape type cannot be null.");
        }

        switch (shapeType.toLowerCase()) {
            case "circle":
                // Expects: dimensions[0] = radius
                return new Circle(dimensions[0]);

            case "rectangle":
                // Expects: dimensions[0] = width, dimensions[1] = height
                return new Rectangle(dimensions[0], dimensions[1]);

            case "triangle":
                // Expects: dimensions[0] = base, dimensions[1] = height
                return new Triangle(dimensions[0], dimensions[1]);

            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

// 6. Client / Main Demonstration Class
public class FactoryPattern {
    public static void main(String[] args) {

        // -------------------------------------------------------------------
        // The client delegates object creation to ShapeFactory.
        // It works entirely through the Shape interface and never references
        // Circle, Rectangle, or Triangle directly.
        // -------------------------------------------------------------------

        System.out.println("--- Scenario 1: Creating a Circle via Factory ---");
        Shape circle = ShapeFactory.createShape("circle", 5.0);
        circle.draw();
        System.out.println("Area: " + String.format("%.2f", circle.area()));
        System.out.println();

        System.out.println("--- Scenario 2: Creating a Rectangle via Factory ---");
        Shape rectangle = ShapeFactory.createShape("rectangle", 4.0, 6.0);
        rectangle.draw();
        System.out.println("Area: " + String.format("%.2f", rectangle.area()));
        System.out.println();

        System.out.println("--- Scenario 3: Creating a Triangle via Factory ---");
        Shape triangle = ShapeFactory.createShape("triangle", 3.0, 7.0);
        triangle.draw();
        System.out.println("Area: " + String.format("%.2f", triangle.area()));
        System.out.println();

        // -------------------------------------------------------------------
        // Notice: If we want to add a new shape (e.g., Pentagon), we only need to:
        //   1. Create a new class 'Pentagon implements Shape'
        //   2. Add a case "pentagon" in ShapeFactory.createShape()
        // The client code below stays UNCHANGED — this is the power of Factory Pattern.
        // -------------------------------------------------------------------

        System.out.println("--- Scenario 4: Handling an unknown shape ---");
        try {
            Shape unknown = ShapeFactory.createShape("hexagon", 5.0);
            unknown.draw();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
