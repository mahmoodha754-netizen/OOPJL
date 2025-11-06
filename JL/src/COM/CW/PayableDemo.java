package COM.CW;
    interface Payable {
        void generatePayslip();
    }

    // Contractor class implementing Payable
    class Contractor implements Payable {
        private String name;
        private double hourlyRate;
        private int hoursWorked;

        public Contractor(String name, double hourlyRate, int hoursWorked) {
            this.name = name;
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public void generatePayslip() {
            double pay = hourlyRate * hoursWorked;
            System.out.println("----- Contractor Payslip -----");
            System.out.println("Name: " + name);
            System.out.println("Hourly Rate: " + hourlyRate);
            System.out.println("Hours Worked: " + hoursWorked);
            System.out.println("Total Pay: " + pay);
            System.out.println();
        }
    }

    // FullTimeEmployee class implementing Payable
    class FullTimeEmployee implements Payable {
        private String name;
        private double monthlySalary;

        public FullTimeEmployee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        @Override
        public void generatePayslip() {
            System.out.println("----- Full-Time Employee Payslip -----");
            System.out.println("Name: " + name);
            System.out.println("Monthly Salary: " + monthlySalary);
            System.out.println();
        }
    }

    // Driver program
    public class PayableDemo {
        public static void main(String[] args) {
            // Interface references demonstrating polymorphism
            Payable p1 = new Contractor("Ravi", 500.0, 40);
            Payable p2 = new FullTimeEmployee("Anjali", 60000.0);

            // Both calls use the same interface method — polymorphism in action
            p1.generatePayslip();
            p2.generatePayslip();
        }
    }


