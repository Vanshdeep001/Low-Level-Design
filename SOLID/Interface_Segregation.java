package SOLID;

// a class should not be forced to implement methods it does not need
// split large interfaces into smaller specific ones

// small focused interfaces instead of one big interface
interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

interface Faxable {
    void fax();
}

// basic printer only needs to print — not forced to implement scan or fax
class BasicPrinter implements Printable {
    @Override
    public void print() {
        System.out.println("BasicPrinter: printing document");
    }
}

// scanner only needs to scan
class BasicScanner implements Scannable {
    @Override
    public void scan() {
        System.out.println("BasicScanner: scanning document");
    }
}

// all-in-one machine implements only what it needs
class AllInOnePrinter implements Printable, Scannable, Faxable {
    @Override
    public void print() {
        System.out.println("AllInOnePrinter: printing document");
    }

    @Override
    public void scan() {
        System.out.println("AllInOnePrinter: scanning document");
    }

    @Override
    public void fax() {
        System.out.println("AllInOnePrinter: sending fax");
    }
}

public class  Interface_Segregation{
    public static void main(String[] args) {
        BasicPrinter basicPrinter = new BasicPrinter();
        basicPrinter.print();
        System.out.println("---");

        BasicScanner basicScanner = new BasicScanner();
        basicScanner.scan();
        System.out.println("---");

        AllInOnePrinter allInOne = new AllInOnePrinter();
        allInOne.print();
        allInOne.scan();
        allInOne.fax();
    }
}