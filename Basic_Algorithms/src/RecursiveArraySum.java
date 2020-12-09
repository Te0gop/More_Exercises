import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    /*
    Write a program that finds the sum of all elements in an integer array. Use recursion.
Note: In practice recursion should not be used here (instead use an iterative solution), this is just an exercise.
Examples
Input	       Output
1 2 3 4	       10
-1 0 1	       0

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = sumArr(arr, 0);
        System.out.println(sum);
    }

    private static int sumArr(int[] arr, int index) {

        if (index == arr.length - 1) {
            return arr[index];
        }

        return arr[index] + sumArr(arr, index + 1);
    }
}
