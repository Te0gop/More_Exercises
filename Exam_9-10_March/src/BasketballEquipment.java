import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int tax = Integer.parseInt(scan.nextLine());

        double basketShoes = tax * 0.60;
        double clothes = basketShoes * 0.80;
        double ball = clothes / 4;
        double items = ball / 5;

        double totalSum = basketShoes + clothes + ball + items + tax;
        System.out.printf("%.2f", totalSum);

    }
}