package COM.Day3;

class Person {
    String name;
    String dateOfBirth;

    Person(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
    }
}

class Teacher extends Person {
    double salary;
    String subject;

    Teacher(String name, String dateOfBirth, double salary, String subject) {
        super(name, dateOfBirth);
        this.salary = salary;
        this.subject = subject;
    }

    void displayTeacherInfo() {
        System.out.println("----- Teacher Info -----");
        displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Salary: " + salary);
    }
}

class Student extends Person {
    String studentId;

    Student(String name, String dateOfBirth, String studentId) {
        super(name, dateOfBirth);
        this.studentId = studentId;
    }

    void displayStudentInfo() {
        System.out.println("----- Student Info -----");
        displayInfo();
        System.out.println("Student ID: " + studentId);
    }
}

class CollegeStudent extends Student {
    String collegeName;
    String year;

    CollegeStudent(String name, String dateOfBirth, String studentId, String collegeName, String year) {
        super(name, dateOfBirth, studentId);
        this.collegeName = collegeName;
        this.year = year;
    }

    void displayCollegeStudentInfo() {
        System.out.println("----- College Student Info -----");
        displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("College Name: " + collegeName);
        System.out.println("Year: " + year);
    }
}

public class schoolapplication {
    public static void main(String[] args) {
        // Create objects
        Teacher teacher = new Teacher("Mrs. Anita", "12-05-1980", 55000, "Mathematics");
        Student student = new Student("Rahul", "10-03-2005", "S123");
        CollegeStudent collegeStudent = new CollegeStudent("Sneha", "20-07-2003", "C567", "ABC College", "Third Year");

        // Display information
        teacher.displayTeacherInfo();
        System.out.println();
        student.displayStudentInfo();
        System.out.println();
        collegeStudent.displayCollegeStudentInfo();
    }
}
