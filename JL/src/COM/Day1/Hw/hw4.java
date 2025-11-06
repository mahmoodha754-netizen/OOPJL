package COM.Day1.Hw;
import java.util.Scanner;
public class hw4 {
    public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);

            // Ask user to enter a number
            System.out.print("Enter an integer: ");
            int num = sc.nextInt();

            // Check conditions
            if (num > 0) {
                System.out.println("The number is Positive");
            } else if (num < 0) {
                System.out.println("The number is Negative");
            } else {
                System.out.println("The number is Zero");
            }
        }
    }
