import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /*
    Create class BankAccount.
The class should have private fields for:
•	Id: int (Starts from 1 and increments for every new account)
•	Balance: double
•	Interest rate: double (Shared for all accounts. Default value: 0.02)
The class should also have public methods for:
•	setInterestRate(double interest): void (static)
•	getInterest(int Years): double
•	deposit(double amount): void
Create a test client supporting the following commands:
•	Create
•	Deposit {Id} {Amount}
•	SetInterest {Interest}
•	GetInterest {ID} {Years}
•	End
Input	              Output
Create                Account ID1 created
Deposit 1 20          Deposited 20 to ID1
GetInterest 1 10      4.00
End

     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> map = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] command = input.split("\\s+");

            if (command[0].equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                map.put(bankAccount.getId(), bankAccount);
                System.out.println("Account ID" + bankAccount.getId() + " created");
            } else if (command[0].equals("Deposit")) {
                if (map.containsKey(Integer.parseInt(command[1]))) {
                    BankAccount bankAccount = map.get(Integer.parseInt(command[1]));
                    bankAccount.deposit(Double.parseDouble(command[2]));
                    System.out.println("Deposited " + command[2] + " to ID" + bankAccount.getId());
                } else {
                    System.out.println("Account does not exist.");
                }
            } else if (command[0].equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(command[1]));
            } else if (command[0].equals("GetInterest")) {
                if (map.containsKey(Integer.parseInt(command[1]))) {
                    BankAccount bankAccount = map.get(Integer.parseInt(command[1]));
                    System.out.printf("%.2f%n", bankAccount.getInterest(Integer.parseInt(command[2])));
                } else {
                    System.out.println("Account does not exist.");
                }
            }
            input = scanner.nextLine();
        }
    }
}
