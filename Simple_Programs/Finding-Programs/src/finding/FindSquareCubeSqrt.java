package finding;

import java.util.Scanner;

public class FindSquareCubeSqrt {
    // Write a program to find square root cube root of integer.

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Integer Number ");
        int num = sc.nextInt();
        System.out.println("Square of " + num + " is " + Math.pow(num, 2));
        System.out.println("cube of " + num + " is " + Math.pow(num, 3));
        System.out.println("Square Root of " + num + " is " + Math.sqrt(num));
    }
}
