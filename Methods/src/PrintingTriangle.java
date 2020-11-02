import java.util.Scanner;

public class PrintingTriangle {
    /*
    Create a method for printing triangles as shown below
    Examples:
Input	Output
3	    1
        1 2
        1 2 3
        1 2
        1

4	    1
        1 2
        1 2 3
        1 2 3 4
        1 2 3
        1 2
        1

     */

    static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void printSecondLine(int n) {
        for (int i = 0; i < n; i++) {
            printLine(1, i);
        }
    }

    static void printLastLine(int n) {
        for (int i = n - 1; i >= 1 ; i--) {
            printLine(1, i);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        printSecondLine(number);
        printLine(1, number);
        printLastLine(number);
    }
}
