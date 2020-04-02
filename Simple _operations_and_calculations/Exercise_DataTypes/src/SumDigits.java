import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = scan.next();
        int sumOfDigits = 0;

        for (int i = 0; i < number.length() ; i++) {
            char digit = number.charAt(i);
            int digitAsNum = Integer.parseInt(String.valueOf(digit));
            sumOfDigits += digitAsNum;
        }
        System.out.println(sumOfDigits);
    }
}
