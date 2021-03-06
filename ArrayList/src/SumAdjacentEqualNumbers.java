import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    /*
    Write a program to sum all adjacent equal numbers in a list of decimal numbers, starting from left to right.
	After two numbers are summed, the obtained result could be equal to some of its neighbors and should be summed
as well (see the examples below).
	Always sum the leftmost two equal neighbors (if several couples of equal neighbors are available).
Examples
Input	                Output	      Explanation
3 3 6 1	                12 1	      3 3 6 1  6 6 1  12 1
8 2 2 4 8 16	        16 8 16	      8 2 2 4 8 16  8 4 4 8 16  8 8 8 16  16 8 16
5 4 2 1 1 4	            5 8 4	      5 4 2 1 1 4  5 4 2 2 4  5 4 4 4  5 8 4
0.1 0.1 5 -5	        0.2 5 -5	  0.1 0.1 5 -5  0.2 5 -5
     */

    public static String joinElementsByDelimiter(List<Double> items, String delimiter) {
        String output = "";
        for(Double item : items) {
            output += (new DecimalFormat("0.#").format(item) + delimiter);
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> list = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).equals(list.get(i + 1))) {
                list.set(i, (list.get(i) + list.get(i + 1)));
                list.remove(i + 1);
                i = -1;
            }
        }
        String output = joinElementsByDelimiter(list, " ");
        System.out.println(output);




    }
}
