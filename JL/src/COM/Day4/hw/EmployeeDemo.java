package COM.Day4.hw;

// Base class
class Employee {
    String name;
    double salary;

    // Constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method to be overridden
    double calculateBonus() {
        return salary * 0.05; // Default 5% bonus
    }
}

// Derived class: Manager
class Manager extends Employee {
    Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.10; // Managers get 10% bonus
    }
}

// Derived class: Intern
class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.02; // Interns get 2% bonus
    }
}

// Main class
public class EmployeeDemo {
    public static void main(String[] args) {
        // Creating different Employee type objects
        Employee e1 = new Manager("Alice", 80000);
        Employee e2 = new Intern("Bob", 20000);
        Employee e3 = new Employee("Charlie", 50000);

        // Store them in an array of type Employee
        Employee[] employees = { e1, e2, e3 };

        // Demonstrate polymorphism
        for (Employee emp : employees) {
            System.out.println(emp.name + " bonus: " + emp.calculateBonus());
        }
    }
}
