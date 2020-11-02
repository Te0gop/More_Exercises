import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    /*
Create a method that calculates and returns the value of a number raised to a given power.
Examples
Input	Output
2
8	    256

5.5
3	    166.375
     */

    private static double mathPower(double number, int power) {
        return Math.pow(number, power);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        int power = scan.nextInt();
        System.out.println(new DecimalFormat("0.####").format(mathPower(number, power)));

    }
}
