package exercise;

import java.util.Arrays;
import java.util.Scanner;
/*
Write a program that calculates the difference between the sum of the even and the sum of the odd numbers in an array.
Examples
Input	             Output	   Comments
1 2 3 4 5 6	          3	       2 + 4 + 6 = 12
                               1 + 3 + 5 = 9
                               12 – 9 = 3

3 5 7 9	             -24

2 4 6 8 10	          30
 */

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(" ");

        int[] numbers = new int[arr.length];
        int evenNumbersSum = 0;
        int oddNumberSum = 0;

        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);

            if(numbers[i] % 2 == 0) {
                evenNumbersSum += numbers[i];
            } else {
                oddNumberSum += numbers[i];
            }
        }
        System.out.println(evenNumbersSum - oddNumberSum);

// second solution:

//        int[] numbers = Arrays
//                .stream(scan.nextLine().split(" "))
//                .mapToInt(e -> Integer.parseInt(e))
//                .toArray();
//
//        int evenSum = 0;
//        int oddSum = 0;
//
//        for(int num : numbers) {
//            if (num % 2 == 0) {
//                evenSum += num;
//            } else {
//                oddSum += num;
//            }
//        }
//        System.out.println(evenSum - oddSum);
    }
}
