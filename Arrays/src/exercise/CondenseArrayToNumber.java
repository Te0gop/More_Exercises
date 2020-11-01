package exercise;

import java.util.Scanner;
/*
Write a program to read an array of integers and condense them by summing adjacent couples of elements until a
single integer is obtained. For example, if we have 3 elements {2, 10, 3}, we sum the first two and the second two
elements and obtain {2+10, 10+3} = {12, 13}, then we sum again all adjacent elements and obtain {12+13} = {25}.
Examples
Input	      Output	    Comments
2 10 3	      25	        2 10 3  2+10 10+3  12 13  12 + 13  25
5 0 4 1 2	  35	        5 0 4 1 2  5+0 0+4 4+1 1+2  5 4 5 3  5+4 4+5 5+3  9 9 8  9+9 9+8  18 17  18+17  35
1	          1	            1 is already condensed to number
 */
public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(" ");
        int[] condenseArray = new int[arr.length];

        for (int i = 0; i < condenseArray.length; i++) {
            condenseArray[i] = Integer.parseInt(arr[i]);
        }

       while (condenseArray.length > 1) {
           int[] temp = new int[condenseArray.length-1];

           for (int i = 0; i < condenseArray.length - 1; i++) {
               temp[i] = condenseArray[i] + condenseArray[i+1];
           }
           condenseArray = temp;
       }
        System.out.println(condenseArray[0]);
    }
}
