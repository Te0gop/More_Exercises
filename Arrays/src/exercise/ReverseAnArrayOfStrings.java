package exercise;

import java.util.Scanner;
/*
Write a program to read an array of strings, reverse it and print its elements.
The input consists of a sequence of space separated strings. Print the output on a single line (space separated).
Examples

Input	         Output
a b c d e	     e d c b a
-1 hi ho w	     w ho hi -1
 */
public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(" ");

        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }

        for (String a: arr) {
            System.out.print(a + " ");
        }
//        System.out.println(String.join(" ", arr));
    }
}
