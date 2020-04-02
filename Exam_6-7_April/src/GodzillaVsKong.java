import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = scan.nextDouble();
        int statists = scan.nextInt();
        double clothes = scan.nextDouble();

        if (statists > 150) {
            clothes *= 0.90;
        }
        double decor = budget * 0.10;
        double clothesSum = statists * clothes;
        double moneyNeeded = decor + clothesSum;

        if (moneyNeeded > budget) {
            double diff = moneyNeeded - budget;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", diff);
        } else {
            double diff = budget - moneyNeeded;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);
        }

    }
}
