import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private double balance;
    private List<String> transactionHistory;
    private Scanner scanner;

    public ATM() {
        balance = 0.0;
        transactionHistory = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");

        boolean quit = false;
        while (!quit) {
            System.out.println("\nATM Functionalities:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice (1-5): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayTransactionHistory();
                    break;
                case "2":
                    performWithdrawal();
                    break;
                case "3":
                    performDeposit();
                    break;
                case "4":
                    performTransfer();
                    break;
                case "5":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the ATM!");
    }

    private void displayTransactionHistory() {
        System.out.println("\nTransaction History:");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions to display.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    private void performWithdrawal() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            String transaction = "Withdrawal: $" + amount;
            transactionHistory.add(transaction);
            System.out.println("Withdrawal successful.");
        }
    }

    private void performDeposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else {
            balance += amount;
            String transaction = "Deposit: $" + amount;
            transactionHistory.add(transaction);
            System.out.println("Deposit successful.");
        }
    }

    private void performTransfer() {
        System.out.print("Enter the recipient's account number: ");
        String recipient = scanner.nextLine();
        System.out.print("Enter the amount to transfer: $");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            String transaction = "Transfer: $" + amount + " to account " + recipient;
            transactionHistory.add(transaction);
            System.out.println("Transfer successful.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
