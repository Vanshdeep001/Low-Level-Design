package Inheritence;

class Employee {
    private String name;
    private int employeeId;
    private double baseSalary;

    public Employee(String name, int employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void work() {
        System.out.println(name + " is working");
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Base Salary: " + baseSalary);
    }
}

class Manager extends Employee {
    private String department;
    private double bonus;

    public Manager(String name, int employeeId, double baseSalary, String department, double bonus) {
        super(name, employeeId, baseSalary);
        this.department = department;
        this.bonus = bonus;
    }

    public String getDepartment() {
        return department;
    }

    public void conductMeeting() {
        System.out.println(getName() + " is conducting a meeting for " + department + " department");
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

class Developer extends Employee {
    private String programmingLanguage;
    private double overtimePay;

    public Developer(String name, int employeeId, double baseSalary, String programmingLanguage, double overtimePay) {
        super(name, employeeId, baseSalary);
        this.programmingLanguage = programmingLanguage;
        this.overtimePay = overtimePay;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void writeCode() {
        System.out.println(getName() + " is writing code in " + programmingLanguage);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + overtimePay;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("Overtime Pay: " + overtimePay);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

class Intern extends Employee {
    private String college;
    private int durationMonths;

    public Intern(String name, int employeeId, double baseSalary, String college, int durationMonths) {
        super(name, employeeId, baseSalary);
        this.college = college;
        this.durationMonths = durationMonths;
    }

    public String getCollege() {
        return college;
    }

    public void learn() {
        System.out.println(getName() + " is learning from " + college);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("College: " + college);
        System.out.println("Duration: " + durationMonths + " months");
        System.out.println("Stipend: " + calculateSalary());
    }
}

public class inheritence2 {
    public static void main(String[] args) {
        Manager manager = new Manager("Suresh Kumar", 101, 80000, "Engineering", 20000);
        manager.displayInfo();
        manager.work();
        manager.conductMeeting();
        System.out.println("---");

        Developer developer = new Developer("Anjali Mehta", 102, 60000, "Java", 10000);
        developer.displayInfo();
        developer.work();
        developer.writeCode();
        System.out.println("---");

        Intern intern = new Intern("Rohit Verma", 103, 15000, "IIT Delhi", 6);
        intern.displayInfo();
        intern.work();
        intern.learn();
    }
}