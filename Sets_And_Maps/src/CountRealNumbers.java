import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    /*
    Write a program that counts the occurrence of real numbers. The input is a single line with real numbers separated
    by spaces. Print the numbers in the order of appearance. All numbers must be formatted to one digit after
    the decimal point.
Examples
Input	                            Output
-2.5 4 3 -2.5 -5.5 4 3 3 -2.5 3
	                                -2.5 -> 3
                                     4.0 -> 2
                                     3.0 -> 4
                                     -5.5 -> 1

     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        double[] values = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double value : values) {
            if (!numbers.containsKey(value)) {
                numbers.put(value, 1);
            } else {
                numbers.put(value, numbers.get(value) +1);
            }
        }

        for (Double key : numbers.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, numbers.get(key)));
        }
    }
}
