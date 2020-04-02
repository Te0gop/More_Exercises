import java.math.BigDecimal;
import java.util.Scanner;

public class BigInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int digitsCount = scan.nextInt();
        BigDecimal sumOfdigits = new BigDecimal(0);

        for (int i = 0; i < digitsCount; i++) {
            String number = scan.next();
            BigDecimal numberDec = new BigDecimal(number);
            sumOfdigits = sumOfdigits.add(numberDec);

        }
        System.out.println(sumOfdigits);
    }
}
