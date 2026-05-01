package SOLID;

// classes should be open for extension but closed for modification

// base class — never modified when adding new discount types
abstract class Discount {
    protected String customerType;

    public Discount(String customerType) {
        this.customerType = customerType;
    }

    // subclasses extend this to add new behaviour
    public abstract double applyDiscount(double price);
}

// extend by adding new classes, not by changing existing ones
class RegularDiscount extends Discount {
    public RegularDiscount() {
        super("Regular");
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * 0.05); // 5% discount
    }
}

class PremiumDiscount extends Discount {
    public PremiumDiscount() {
        super("Premium");
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * 0.20); // 20% discount
    }
}

// new discount added without touching any existing class
class StudentDiscount extends Discount {
    public StudentDiscount() {
        super("Student");
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * 0.10); // 10% discount
    }
}

public class Ocp {
    public static void main(String[] args) {
        double price = 1000;

        Discount[] discounts = {
            new RegularDiscount(),
            new PremiumDiscount(),
            new StudentDiscount()
        };

        for (Discount d : discounts) {
            System.out.println(d.customerType + " customer price: " + d.applyDiscount(price));
        }
    }
}