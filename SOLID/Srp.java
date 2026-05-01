package SOLID;

// A class should have only one reason to change

// Only handles student data
class Student {
    private String name;
    private int age;
    private double marks;

    public Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }
}

// Only handles report generation
class ReportGenerator {
    public void generateReport(Student student) {
        System.out.println("--- Student Report ---");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Marks: " + student.getMarks());
    }
}

// Only handles saving student data
class StudentRepository {
    public void save(Student student) {
        System.out.println("Saving student " + student.getName() + " to database");
    }
}

// Only handles sending notifications
class NotificationService {
    public void sendNotification(Student student) {
        System.out.println("Sending result notification to " + student.getName());
    }
}

public class Srp {
    public static void main(String[] args) {
        Student student = new Student("Rahul Sharma", 20, 85.5);

        // each class does only its own job
        ReportGenerator report = new ReportGenerator();
        report.generateReport(student);
        System.out.println("---");

        StudentRepository repo = new StudentRepository();
        repo.save(student);
        System.out.println("---");

        NotificationService notification = new NotificationService();
        notification.sendNotification(student);
    }
}