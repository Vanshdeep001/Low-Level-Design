package Inheritence;

class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void bark() {
        System.out.println(getName() + " is barking");
    }

    public void fetch() {
        System.out.println(getName() + " is fetching the ball");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}

class GuideDog extends Dog {
    private String owner;

    public GuideDog(String name, int age, String breed, String owner) {
        super(name, age, breed);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void guide() {
        System.out.println(getName() + " is guiding " + owner);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Owner: " + owner);
    }
}

public class inheritence1 {
    public static void main(String[] args) {
        Animal animal = new Animal("Generic Animal", 3);
        animal.displayInfo();
        animal.eat();
        animal.sleep();
        System.out.println("---");

        Dog dog = new Dog("Bruno", 5, "Labrador");
        dog.displayInfo();
        dog.eat();
        dog.bark();
        dog.fetch();
        System.out.println("---");

        GuideDog guideDog = new GuideDog("Max", 4, "German Shepherd", "Ramesh");
        guideDog.displayInfo();
        guideDog.eat();
        guideDog.bark();
        guideDog.guide();
    }
}