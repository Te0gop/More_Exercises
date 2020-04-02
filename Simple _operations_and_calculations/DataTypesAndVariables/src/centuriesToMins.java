import java.util.Scanner;

public class centuriesToMins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        byte centuries = scan.nextByte();
        int years = centuries * 100;
        int days = (int) (years * 365.2422);
        int hours = days * 24;
        int minutes = hours * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centuries, years, days, hours, minutes);

    }
}
