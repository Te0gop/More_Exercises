package recursion;
//Each member of the Fibonacci sequence is calculated from the sum of the two previous members. The first two elements
// are 1, 1. Therefore the sequence goes as 1, 1, 2, 3, 5, 8, 13, 21, 34…
//The following sequence can be generated with an array, but that’s easy, so your task is to implement it recursively.
//If the function getFibonacci(n) returns the nth Fibonacci number, we can express it using
// getFibonacci(n) = getFibonacci(n-1) + getFibonacci(n-2).
//However, this will never end and in a few seconds a Stack Overflow Exception is thrown. In order for the recursion to
// stop it has to have a "bottom". The bottom of the recursion is getFibonacci(1), and should return 1. The same goes
// for getFibonacci(0).

//Input
//•	On the only line in the input the user should enter the wanted Fibonacci number N where 1 ≤ N ≤ 49

//Output
//•	The output should be the nth Fibonacci number counting from 0

import java.util.Scanner;

//Examples
//Input	        Output
//5	            8
//10	        89
//21	        17711
public class RecursiveFibonacci {
    static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacci(n));
//        System.out.println(fibonacci(10)); // 89
//        System.out.println(fibonacci(50)); // This will hang!
    }

}