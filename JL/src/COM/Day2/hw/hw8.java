package COM.Day2.hw;

public class hw8 {
        public static void main(String args[]) {
            // Initialize a character variable
            char ch = 'A';  // you can change this value to test

            // Check if it's an alphabet
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                System.out.println("Alphabet");
            }
            // Check if it's a digit
            else if (ch >= '0' && ch <= '9') {
                System.out.println("Digit");
            }
            // Otherwise it's a special character
            else {
                System.out.println("Special Character");
            }
        }
    }
