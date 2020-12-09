import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    /*
    On the first line you are given the length of two sets n and m. On the next n + m lines there are n numbers
     that are in the first set and m numbers that are in the second one. Find all non-repeating element that
      appears in both of them, and print them in same order at the console:
Set with length n = 4: {1, 3, 5, 7}
Set with length m = 3: {3, 4, 5}
Set that contains all repeating elements -> {3, 5}
Examples
Input	       Output
4 3            3 5
1
3
5
7
3
4
5
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setsSize = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> nSet = new LinkedHashSet<>();
        Set<Integer> mSet = new LinkedHashSet<>();


        for (int i = 0; i < setsSize[0]; i++) {
            nSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < setsSize[1]; i++) {
            mSet.add(Integer.parseInt(scanner.nextLine()));
        }

        nSet.retainAll(mSet);

        for (Integer i : nSet) {
            System.out.print(i + " ");
        }
    }
}
