import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
Write a program that reads one line of Integers separated by ", ".
•	Print the even numbers
•	Sort them in ascending order
•	Print them again.
Use 2 Lambda Expresions to do so.
Examples
Input	                               Output
4, 2, 1, 3, 5, 7, 1, 4, 2, 12	       4, 2, 4, 2, 12
                                       2, 2, 4, 4, 12

1, 3, 5	                               (no output)

2, 4, 6	                               2, 4, 6
                                       2, 4, 6
 */


public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .toArray();

        printArray(numbers);
        Arrays.sort(numbers);
        printArray(numbers);

        // Second way without using static method:
//        Consumer<int[]> consumer = arr -> System.out.println(Arrays.stream(numbers)
//                .mapToObj(Integer::toString) // we use mapToObj, because we work with the primitive (int) not with wrapper
//                .collect(Collectors.joining(", ")));
//
//        consumer.accept(numbers);
//        Arrays.sort(numbers);
//        consumer.accept(numbers);

    }

    private static void printArray(int[] numbers) {
        System.out.println(Arrays.stream(numbers)
                .mapToObj(Integer::toString) // we use mapToObj, because we work with the primitive (int) not with wrapper
                .collect(Collectors.joining(", ")));
    }
}
