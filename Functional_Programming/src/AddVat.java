import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVat {
    /*
    Write a program that reads one line of Double prices separated by ", ".
    Print the prices with added VATs for all of them. Format them to the 2nd digit after the decimal point.
    The order of the prices must remain the same.
Use an UnaryOperator<Double>

Examples
Input	                       Output
1.38, 2.56, 4.4	               Prices with VAT:
                               1.66
                               3.07
                               5.28

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(str -> Double.parseDouble(str) * 1.20)
                .forEach(vatValue -> System.out.println(String.format("%.2f", vatValue)));

    }
}
