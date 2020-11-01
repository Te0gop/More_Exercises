package exercise;

import java.util.Scanner;
/*
Read n numbers and print them in reverse order.
Examples
Input	Output
3
10
20
30	    30 20 10

3
30
20
10	    10 20 30

1
10	    10
 */

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numbers = Integer.parseInt(scan.nextLine());
        int[] arr = new int [numbers];

        for (int i = 0; i < numbers; i++) {
            arr[i] = Integer.parseInt(scan.nextLine());
        }

        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }


    }

}
