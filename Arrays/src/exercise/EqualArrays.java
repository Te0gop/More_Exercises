package exercise;

import java.util.Arrays;
import java.util.Scanner;
/*
Read two arrays and print on the console whether they are identical or not.
Arrays are identical if their elements are equal. If the arrays are identical find the sum of the first one
and print on the console following message: "Arrays are identical. Sum: {sum}", otherwise find the first index
where the arrays differ and print on the console following message: "Arrays are not identical. Found difference at
{index} index."
Examples
Input	    Output
10 20 30
10 20 30	Arrays are identical. Sum: 60

1 2 3 4 5
1 2 4 3 5	Arrays are not identical. Found difference at 2 index.

1
10	        Arrays are not identical. Found difference at 0 index.
 */
public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstArray = scan.nextLine().split(" ");
        String[] secondArray = scan.nextLine().split(" ");
        boolean isEqual = true;

        int sumOfNumbers = 0;

        for (int i = 0; i < firstArray.length; i++) {

            if((Integer.parseInt(firstArray[i]) == Integer.parseInt(secondArray[i]))) {
                sumOfNumbers += Integer.parseInt(firstArray[i]);
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                isEqual = false;
                break;
            }
        }
        if(isEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sumOfNumbers);
        }

        //Second solution:
//        int sum = 0;
//        boolean isEqual = true;
//
//        int[] firstArray = Arrays
//                .stream(scan.nextLine().split(" "))
//                .mapToInt(e -> Integer.parseInt(e))
//                .toArray();
//
//        int[] secondArray = Arrays
//                .stream(scan.nextLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        for (int i = 0; i < firstArray.length; i++) {
//            sum += firstArray[i];
//            if(firstArray[i] != secondArray[i]) {
//                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
//                isEqual = false;
//                break;
//            }
//        }
//        if(isEqual) {
//            System.out.printf("Arrays are identical. Sum: %d", sum);
//        }
    }
}
