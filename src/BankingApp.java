import java.util.Scanner;

public class BankingApp {
    private final Scanner scanner;
    private final BankAccount account;

    public BankingApp(BankAccount account) {
        this.scanner = new Scanner(System.in);
        this.account = account;
    }

    public void start() {
        boolean running = true;

        System.out.println("\nWelcome to Simple Banking Application");
        System.out.println("Account Holder: " + account.getAccountHolderName());

        while (running) {
            displayMenu();

            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    depositMoney();
                    break;

                case 2:
                    withdrawMoney();
                    break;

                case 3:
                    displayBalance();
                    break;

                case 4:
                    running = false;
                    System.out.println("\nThank you for using the Banking Application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select an option from 1 to 4.");
            }
        }

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n===== Banking Application =====");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Balance Inquiry");
        System.out.println("4. Exit");
    }

    private void depositMoney() {
        double amount = readAmount("Enter deposit amount: ");

        if (account.deposit(amount)) {
            System.out.printf("Deposit successful.%n");
            System.out.printf("Updated Balance: ₹%.2f%n", account.getBalance());
        } else {
            System.out.println("Deposit failed. Amount must be greater than zero.");
        }
    }

    private void withdrawMoney() {
        double amount = readAmount("Enter withdrawal amount: ");

        if (amount <= 0) {
            System.out.println("Withdrawal failed. Amount must be greater than zero.");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.printf(
                    "Insufficient balance. Your current balance is: ₹%.2f%n",
                    account.getBalance()
            );
            return;
        }

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
            System.out.printf("Updated Balance: ₹%.2f%n", account.getBalance());
        }
    }

    private void displayBalance() {
        System.out.println("\n===== Balance Inquiry =====");
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.printf("Current Balance: ₹%.2f%n", account.getBalance());
    }

    private int readMenuChoice() {
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
            }
        }
    }

    private double readAmount(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a valid numeric amount.");
            }
        }
    }
}