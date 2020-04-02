import java.util.Scanner;

public class sumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCount = scan.nextInt();
        int totalSum = 0;

        for (int i = 0; i < numCount; i++) {
            String digit = scan.next();
            totalSum += digit.charAt(0);

        }
        System.out.printf("The sum equals: %d", totalSum);
    }

}
