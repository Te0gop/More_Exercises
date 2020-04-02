import java.util.Scanner;

public class mToKm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int meteres = scan.nextInt();
        double kilometeres =  (meteres / 1000.00);
        System.out.printf("%.2f", kilometeres);

    }
}
