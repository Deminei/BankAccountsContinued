public class BankAccount {//Class with 3 attributes
    public int accountNumber;
    public double balance;
    public String accountHolderName;

    //Constructor
    public BankAccount(int index, double balance, String accountHolderName) {
        this.accountNumber = index + 1;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    public BankAccount(double balance, String accountHolderName) {
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    public void addAccount(BankAccount account) {
        account.addAccount(account);
    }


    //Methods
    public void deposit(double amount) {

        balance += amount;
    }

    public void withdrawal(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
    public void transfer(int accountNumber, double amount) {
        if (balance < amount) {
            System.out.println("Account "+ accountNumber +" now accepted deposit of "+ amount);
            deposit(amount);
        }
    }

}



