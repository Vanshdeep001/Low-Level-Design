

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }
}

class Printer {
    public void print(int value) {
        System.out.println("Printing int: " + value);
    }

    public void print(double value) {
        System.out.println("Printing double: " + value);
    }

    public void print(String value) {
        System.out.println("Printing String: " + value);
    }

    public void print(int value, int copies) {
        for (int i = 0; i < copies; i++) {
            System.out.println("Copy " + (i + 1) + ": " + value);
        }
    }
}

public class polymorphism1 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("add(10, 20): " + calc.add(10, 20));
        System.out.println("add(10, 20, 30): " + calc.add(10, 20, 30));
        System.out.println("add(10.5, 20.5): " + calc.add(10.5, 20.5));
        System.out.println("add(Hello, World): " + calc.add("Hello ", "World"));
        System.out.println("---");

        System.out.println("multiply(5, 6): " + calc.multiply(5, 6));
        System.out.println("multiply(5.5, 6.5): " + calc.multiply(5.5, 6.5));
        System.out.println("multiply(2, 3, 4): " + calc.multiply(2, 3, 4));
        System.out.println("---");

        Printer printer = new Printer();

        printer.print(42);
        printer.print(3.14);
        printer.print("Hello Java");
        printer.print(99, 3);
    }
}