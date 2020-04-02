import java.util.Scanner;

public class concatNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nameOne = scan.next();
        String nameTwo = scan.next();
        String symbol = scan.next();
        System.out.println(nameOne + symbol + nameTwo);

    }
}
