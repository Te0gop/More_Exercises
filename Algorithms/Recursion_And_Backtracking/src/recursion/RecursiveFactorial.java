package recursion;

// Write a program that finds the factorial of a given number. Use recursion.

//Examples
//Input	        Output
//5	            120
//10	        3628800

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = findFactorial(n);
        System.out.println(sum);

    }

    private static int findFactorial(int n) {
//        int sum = n;
//        if(n == 1) {
//            return sum;
//        }
//
//        sum *= findFactorial(n - 1);
//        return sum;

        if(n == 1) {
            return n;
        }
        return findFactorial(n - 1) * n;
    }
}