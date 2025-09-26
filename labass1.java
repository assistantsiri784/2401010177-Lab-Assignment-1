import java.util.*;

class Person {
    String name;
}

class Student extends Person {
    int rollno;
    String course;
    double marks;
    char grade;

    Student() {}

    Student(int rollno, String name, String course, double marks) {
        this.rollno = rollno;
        this.name = name;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    void inputDetails(Scanner sc) {
        System.out.print("Enter Student name: ");
        sc.nextLine(); 
        name = sc.nextLine();

        System.out.print("Enter Student rollno: ");
        rollno = sc.nextInt();

        sc.nextLine(); 
        System.out.print("Enter Student course: ");
        course = sc.nextLine();

        System.out.print("Enter Student marks: ");
        marks = sc.nextDouble();

        calculateGrade();
    }

    void displayDetails() {
        System.out.println("Student name is: " + name);
        System.out.println("Student rollno is: " + rollno);
        System.out.println("Student course is: " + course);
        System.out.println("Student marks: " + marks);
        System.out.println("Student grade is: " + grade);
    }

    void calculateGrade() {
        if (marks > 90) grade = 'A';
        else if (marks > 80) grade = 'B';
        else if (marks > 70) grade = 'C';
        else grade = 'D';
    }
}

public class labass1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student();
                    s.inputDetails(sc);
                    students.add(s); // ✅ fixed
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found!");
                    } else {
                        for (Student st : students) {
                            st.displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
