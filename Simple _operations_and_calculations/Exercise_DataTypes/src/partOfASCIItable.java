import java.util.Scanner;

public class partOfASCIItable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();
        int secNum = scan.nextInt();

        for (int i = number; i <= secNum; i++) {
            char digits = (char) i;
            System.out.print(digits + " ");
        }
    }
}
