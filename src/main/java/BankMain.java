import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        // BankAccount objects created
        BankAccount account1 = new BankAccount(0, 500.0, "James Benedict Esquire's");
        BankAccount account2 = new BankAccount(1, 5000.0, "Dane Tarquin Fahnestock's");
        BankAccount account3 = new BankAccount(2, 300.0, "Olivier Von Stucke Plushbotham VI's");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        System.out.println("Welcome to the Bank!");

        boolean exit = false;

        while (!exit) {
            System.out.println("Are you an existing customer? (-1 to exit) ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            String customer = scanner.nextLine();

            if (customer.equals("-1")) {
                exit = true;
                break;
            } else if (customer.equals("1")) {
                // Logic for existing customer
            // Prompt the user to enter their account number or choose from the existing accounts
                System.out.print("Enter your account number: ");
                int accountNumber = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                BankAccount currentAccount = accounts.get(accountNumber);
                mainMenu(currentAccount); // Call the mainMenu method passing the selected account
            } else if (customer.equals("2")) {
                // Logic for handling the case when customer is "2"
                System.out.println("Let's make a new account!");
                System.out.println("What is the name for the account?");
                String accountHolderName = scanner.nextLine();

                System.out.println("What is the beginning balance for the account?");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                accounts.add(new BankAccount(balance, accountHolderName));
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public static void mainMenu(BankAccount currentAccount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + currentAccount.accountHolderName);
        System.out.println("Welcome to the Main Menu, what would you like to do today?");

        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdrawal");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer to Another Account");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> System.out.println("Balance: " + currentAccount.balance);
                case 2 -> {
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    currentAccount.withdrawal(withdrawAmount);
                    System.out.println(currentAccount.accountHolderName+ "'s new balance after withdraw: " + currentAccount.balance);
                }
                case 3 -> {
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    currentAccount.deposit(depositAmount);
                    System.out.println(currentAccount.accountHolderName+ "'s balance after deposit: " + currentAccount.balance);
                }
                case 4 -> {

                    System.out.print("Enter the amount to transfer: ");
                    int transferAmount = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the account number to transfer to: ");
                    int otherAccount = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    currentAccount.transfer(otherAccount, transferAmount);
                    currentAccount.withdrawal(transferAmount);
                    System.out.println(currentAccount.accountHolderName +"'s balance remaining: " + currentAccount.balance);
                    System.out.println();


                }
                case 0 -> {
                    return; // Exit the mainMenu method and return to the main loop
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}