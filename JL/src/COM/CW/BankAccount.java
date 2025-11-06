package COM.CW;
    class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    // Separate Account class that handles deposits and withdrawals
    class Account {
        private String accountHolder;
        private double balance;

        // Constructor
        public Account(String accountHolder, double balance) {
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        // Deposit method
        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("Current Balance: " + balance);
        }

        // Withdraw method (throws custom exception)
        public void withdraw(double amount) throws InsufficientFundsException {
            System.out.println("Attempting to withdraw: " + amount);
            if (amount > balance) {
                throw new InsufficientFundsException(
                        "Insufficient funds! Available balance: " + balance
                );
            }
            balance -= amount;
            System.out.println("Withdrawal Successful! Remaining Balance: " + balance);
        }

        // Display account details
        public void display() {
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Balance: " + balance);
        }
    }

    // Main class (your class name)
    public class BankAccount {
        public static void main(String[] args) {
            // Create an account
            Account account = new Account("Rahul Sharma", 5000);

            account.display();
            System.out.println();

            account.deposit(2000);
            System.out.println();

            try {
                // Successful withdrawal
                account.withdraw(4000);
                System.out.println();

                // This will cause an exception
                account.withdraw(4000);
            } catch (InsufficientFundsException e) {
                System.out.println("Exception Caught: " + e.getMessage());
            }
        }
    }


