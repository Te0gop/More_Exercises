import java.util.Scanner;

public class Fibonacci {

    //Write a dynamic programming solution for finding nth Fibonacci member.

    public static double[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        dp = new double[n + 1];

        double fib = dpCalcWithRecursion(n);
        double iterativeFib = dpCalcWithIterative(n);
        double recursiveFib = calcRecursiveFib(n);

        System.out.println(fib);
        System.out.println(iterativeFib);
        System.out.println(recursiveFib);

    }

    // using dynamic programming with recursion
    // top-down approach
    // complexity is O(n)
    private static double dpCalcWithRecursion(int n) {
        if(n <= 2) {
            return 1;
        }
        if(dp[n] != 0) {
            // return value at the current index from the arr
            return dp[n];
        }
        // we use array to save the values at specific index, so we don't have to calculate fibonacci again
        // complexity decreases
        return dp[n] = dpCalcWithRecursion(n - 1) + dpCalcWithRecursion(n - 2);
    }

    // iterative way using dynamic programming
    // bottom-up approach
    // complexity is O(n)
    private static double dpCalcWithIterative(int n) {

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // recursive way
    // complexity is O(1.6^n)
    // 1.6 - golden ratio
    private static long calcRecursiveFib(int n) {
        if(n <= 2) {
            return 1;
        }

        return calcRecursiveFib(n - 1) + calcRecursiveFib(n - 2);
    }


}
