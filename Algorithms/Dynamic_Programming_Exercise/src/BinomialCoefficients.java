import java.util.Scanner;

public class BinomialCoefficients {
    //Write a program that finds the binomial coefficient for given non-negative integers n and k.
    //However, this leads to calculating the same coefficient multiple times (a problem which also occurs when solving the Fibonacci problem recursively). Use memoization to improve performance.
    //You can check your answers using the picture below (row and column indices start from 0):
    //Examples
    //Input	        Output
    //3             3
    //2

    //4             1
    //0

    //6             15
    //2

    public static long[][] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1][k + 1];
        long binom = calcBinom(n, k);
        System.out.println(binom);

        //iterative way
        //bottom-up approach
//        for (int row = 0; row <= n; row++) {
//            for (int col = 0; col < Math.min(row, k); col++) {
//                if(col == 0 || col == row) {
//                    memory[row][col] = 1;
//                } else {
//                    memory[row][col] = memory[row - 1][col] + memory[row - 1][col - 1];
//                }
//            }
//        }
    }

    
    private static long calcBinom(int n, int k) {
        if(k == 0 || k == n) {
            return 1;
        }

        if(memory[n][k] != 0) {
            return memory[n][k];
        }
        return memory[n][k] = calcBinom(n-1, k) + calcBinom(n-1, k-1);
    }
}
