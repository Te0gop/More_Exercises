import java.util.Scanner;

public class lowerOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.next();
        char symbol = input.charAt(0);

        if (symbol >= 'a' && symbol <= 'z') {
            System.out.println("lower-case");
        } else {
            System.out.println("upper-case");
        }


    }
}
