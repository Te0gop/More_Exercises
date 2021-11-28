package recursion;

//Write a program that finds the sum of all elements in an integer array. Use recursion.
//Note: In practice this recursion should not be used here (instead use an iterative solution), this is just an exercise.

//Examples
//Input	        Output
//1 2 3 4	    10
//-1 0 1	    0

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Iteration sum: " + sum);

        sum = sumNumbers(arr, 0);

        System.out.println("Recursion sum: " + sum);


    }

    private static int sumNumbers(int[] arr, int index) {
        // Base case
        if(index >= arr.length) {
            return 0;
        }
        // Recursive call
        return arr[index] + sumNumbers(arr,index + 1);
    }

}
