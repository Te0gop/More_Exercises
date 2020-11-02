import java.util.Scanner;
/*
Create a method that prints the sign of an integer number.
Example:
Input	   Output
2	       The number 2 is positive.
-5	       The number -5 is negative.
0	       The number 0 is zero.
 */

public class SignOfInteger {

    static void checkSignOfNumber(int number)  {
        if(number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else {
            System.out.printf("The number 0 is zero.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        checkSignOfNumber(number);
    }
}
