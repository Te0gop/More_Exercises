import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationWithRepetitions {
    //Combinations with Repetition
    //Write a recursive program for generating and printing all combinations with duplicates of k elements
    // from a set of n elements (k <= n). In combinations, the order of elements doesn’t matter, therefore (1 2) and (2 1)
    // are the same combination, meaning that once you print/obtain (1 2), (2 1) is no longer valid.
    //Input	            Output
    //3                 1 1
    //2                 1 2
    //                  1 3
    //                  2 2
    //                  2 3
    //                  3 3

    public static int[] arr;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        arr = new int[k];
        combinations(0, 1);

    }

    private static void combinations(int index, int start) {
        if(index == arr.length) {
            printArr();
        } else {
            for (int i = start; i <= n; i++) {
                arr[index] = i;
                combinations(index + 1, i);
            }
        }
    }

    private static void printArr() {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

}
