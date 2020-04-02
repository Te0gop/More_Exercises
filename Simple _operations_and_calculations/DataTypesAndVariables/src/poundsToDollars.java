import java.util.Scanner;

public class poundsToDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pounds = scan.nextDouble();
        double dollars = pounds * 1.31;
        System.out.printf("%.3f", dollars);
    }
}
