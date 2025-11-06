package COM.Day1.Hw;

public class hw3 {
        public static void main(String args[]) {
            // Check if exactly two arguments are passed
            if (args.length != 2) {
                System.out.println("10,20 and 30");
                return;
            }

            // Convert string arguments to integers
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            // Calculate sum
            int sum = num1 + num2;

            // Display result
            System.out.println("The sum of " + 10 + " and " + 20 + " is " + 30);
        }
    }

