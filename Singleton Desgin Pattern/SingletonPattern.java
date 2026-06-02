// The Singleton Design Pattern ensures that a class has only one instance
// and provides a global point of access to it.

// 1. Singleton Class
class Singleton {
    // A volatile variable to hold the single instance, ensuring thread safety
    private static volatile Singleton instance;

    // A private constructor prevents instantiation from other classes
    private Singleton() {
        System.out.println("Singleton Instance Created.");
    }

    // Public method to provide global access to the instance
    public static Singleton getInstance() {
        // Double-Checked Locking for thread safety and performance
        if (instance == null) { // First check
            synchronized (Singleton.class) {
                if (instance == null) { // Second check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// 2. Client / Main Demonstration Class
public class SingletonPattern {
    public static void main(String[] args) {
        System.out.println("--- Requesting Instance 1 ---");
        Singleton instance1 = Singleton.getInstance();

        System.out.println("--- Requesting Instance 2 ---");
        Singleton instance2 = Singleton.getInstance();

        // Verify that both references point to the same object
        System.out.println();
        System.out.println("Instance 1 HashCode: " + instance1.hashCode());
        System.out.println("Instance 2 HashCode: " + instance2.hashCode());
        System.out.println("Are both instances identical? " + (instance1 == instance2));

        System.out.println();
        instance1.showMessage();
    }
}
