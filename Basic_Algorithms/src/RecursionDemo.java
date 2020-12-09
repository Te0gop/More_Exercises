import java.util.Scanner;

public class RecursionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        printNumbers(0);

    }

    private static void printNumbers(int number) {
        if (number == 10) {
            return;
        } else {
            System.out.println(number);
            printNumbers(number + 1);
        }
    }

}
