package COM.Day2.hw;
import java.util.Scanner;
public class hw5 {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);

            // Ask user to enter a number
            System.out.print("Enter an integer: ");
            int num = sc.nextInt();

            // Check if even or odd
            if (num % 2 == 0) {
                System.out.println("The number is Even");
            } else {
                System.out.println("The number is Odd");
            }
        }
    }
