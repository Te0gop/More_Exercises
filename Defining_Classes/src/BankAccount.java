public class BankAccount {
    private static int idCounter = 1;
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id = BankAccount.idCounter;
        BankAccount.idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
    }
    public double getInterest(int years) {
        return interestRate * years * balance;
    }

}
