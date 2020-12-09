import java.util.Scanner;

public class RecursiveFactorial {
    /*
    Write a program that finds the factorial of a given number. Use recursion.
Note: In practice, recursion should not be used here. Instead, you should use an iterative solution.
This type of solution is for exercise purposes.
Examples
Input	Output
5	    120
10	    3628800

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long result = factorial(n);
        System.out.println(result);
    }

    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
