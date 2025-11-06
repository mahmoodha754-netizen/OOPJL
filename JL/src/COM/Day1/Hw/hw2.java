package COM.Day1.Hw;

public class hw2 {
        public static void main(String args[]) {
            // Check if exactly one argument is passed
            if (args.length != 1) {
                System.out.println("welcome to our restaurant");
                return;
            }

            // Print welcome message
            System.out.println("Welcome " + args[0]);
        }
    }


