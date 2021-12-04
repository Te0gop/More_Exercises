import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationWithoutRepetition {
    // Modify the solution from CombinationWithRepetition program to skip duplicates, e.g. (1 1) is not valid.
    //Input	            Output	        Comments
    //3                 1 2             •	n=3 => we have a set of three elements {1, 2, 3}
    //2	                1 3             •	k=2 => we select two elements out of the three each time
    //                  2 3             •	Duplicates are not allowed, meaning (1 1) is not a valid combination

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

                //difference between CombinationsWithRepetition is in i + 1
                combinations(index + 1, i + 1);
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
