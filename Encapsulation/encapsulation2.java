package Encapsulation;

class Student {
    private String name;
    private int age;
    private double marks;
    private String grade;

    public Student(String name, int age, double marks) {
        this.name = name;
        setAge(age);
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age entered");
        }
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
            calculateGrade();
        } else {
            System.out.println("Invalid marks entered");
        }
    }

    public String getGrade() {
        return grade;
    }

    private void calculateGrade() {
        if (marks >= 90) {
            grade = "A+";
        } else if (marks >= 80) {
            grade = "A";
        } else if (marks >= 70) {
            grade = "B";
        } else if (marks >= 60) {
            grade = "C";
        } else {
            grade = "F";
        }
    }

    public void displayReport() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }
}

public class encapsulation2 {
    public static void main(String[] args) {
        Student student1 = new Student("Priya Singh", 20, 92);
        student1.displayReport();
        System.out.println("---");

        student1.setMarks(75);
        System.out.println("Updated Grade: " + student1.getGrade());
        System.out.println("---");

        Student student2 = new Student("Amit Kumar", 22, 58);
        student2.displayReport();
        System.out.println("---");

        student2.setAge(-5);
        student2.setMarks(110);
    }
}