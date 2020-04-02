import java.util.Scanner;

public class OscarCeremony {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rent = scan.nextInt();

        double statuets = rent * 0.70;
        double catering = statuets * 0.85;
        double soundSystem = catering / 2;
        double totalPrice = rent + statuets + catering + soundSystem;
        System.out.printf("%.2f", totalPrice);
    }
}
