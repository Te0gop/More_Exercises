import java.util.Scanner;

public class CalculateRectangleArea {
    /*
    Create a method that calculates and returns the area of a rectangle by given width and length.
Examples
Input	Output
3
4	    12
     */

    public static int calculateArea (int sideA, int sideB) {
        return sideA * sideB;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sideA = Integer.parseInt(scan.nextLine());
        int sideB = Integer.parseInt(scan.nextLine());
        System.out.println(calculateArea(sideA, sideB));
    }
}
