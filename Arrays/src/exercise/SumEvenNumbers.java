package exercise;

import java.util.Arrays;
import java.util.Scanner;
/*
Read an array from the console and sum only the even numbers.
Examples

Input	             Output
1 2 3 4 5 6	         12
3 5 7 9	             0
2 4 6 8 10	         30
 */
public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(" ");
        int[] numbers = new int[arr.length];
        int evenNumbersSum = 0;

        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);

            if(numbers[i] % 2 == 0) {
                evenNumbersSum += numbers[i];
            }
        }
        System.out.println(evenNumbersSum);


// Second solution:
//        int[] numbers = Arrays
//                .stream(scan.nextLine().split(" "))
//                .mapToInt(e -> Integer.parseInt(e))
//                .toArray();
//
//        int sum = 0;
//
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] % 2 == 0) {
//                sum += numbers[i];
//            }
//        }
//        System.out.println(sum);
    }
}
