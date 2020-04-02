import java.util.Scanner;

public class specialNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        for (int i = 1; i <= number; i++) {
            int specialNum = 0;
            int secondPosition = i % 10;
            int firstPosition = i / 10;

            specialNum += secondPosition;
            specialNum += firstPosition;

            if (specialNum == 5 || specialNum == 7 || specialNum == 11) {
                System.out.printf("%d -> True\n", i);
            } else {
                System.out.printf("%d -> False\n", i);
            }
        }

    }
}
