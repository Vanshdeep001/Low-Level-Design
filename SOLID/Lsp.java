package SOLID;

// subclass objects should be replaceable with parent class objects without breaking the program

class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() { return color; }

    // every shape can calculate its area
    public double calculateArea() {
        return 0;
    }

    public void displayInfo() {
        System.out.println("Shape: " + getClass().getSimpleName());
        System.out.println("Color: " + color);
        System.out.println("Area: " + calculateArea());
    }
}

// substituting Shape with Circle works perfectly fine
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// substituting Shape with Rectangle works perfectly fine
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// substituting Shape with Triangle works perfectly fine
class Triangle extends Shape {
    private double base, height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Lsp {
    public static void main(String[] args) {
        // parent reference holding child objects — all work correctly
        Shape[] shapes = {
            new Circle("Red", 5),
            new Rectangle("Blue", 4, 6),
            new Triangle("Green", 3, 8)
        };

        for (Shape s : shapes) {
            s.displayInfo();
            System.out.println("---");
        }
    }
}