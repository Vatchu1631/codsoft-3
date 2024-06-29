import java.util.Scanner;

public class ATM {
    private Account userAccount;

    public ATM(Account account) {
        this.userAccount = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueUsingATM = true;

        while (continueUsingATM) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");

            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBalance();
                    break;
                case 2:
                    depositFunds(scanner);
                    break;
                case 3:
                    withdrawFunds(scanner);
                    break;
                case 4:
                    continueUsingATM = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void displayBalance() {
        System.out.println("Your current balance is: $" + userAccount.getFunds());
    }

    private void depositFunds(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        userAccount.addFunds(amount);
        System.out.println("Funds deposited successfully.");
        displayBalance();
    }

    private void withdrawFunds(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        userAccount.subtractFunds(amount);
        System.out.println("Funds withdrawn successfully.");
        displayBalance();
    }

    public static void main(String[] args) {
        Account account = new Account(1000); // Initial balance of $1000
        ATM atm = new ATM(account);
        atm.start();
    }
}