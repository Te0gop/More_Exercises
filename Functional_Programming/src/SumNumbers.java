import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
/*
Write a program that reads one line of Integers separated by ", ". Print the count of the numbers and their sum.
Use a Function<String, Integer>
Examples
Input	                           Output
4, 2, 1, 3, 5, 7, 1, 4, 2, 12	   Count = 10
                                   Sum = 41

2, 4, 6	                           Count = 3
                                   Sum = 12
 */

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> printCount = arr -> arr.length;
        Function<int[], String> formatArrSum = arr -> "Sum = " + Arrays.stream(arr).sum();

        System.out.println("Count = " + printCount.apply(numbers));
        System.out.println(formatArrSum.apply(numbers));

    }
}
