import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    //Sort an array of elements using the famous merge sort.
    //Examples
    //Input	            Output
    //5 4 3 2 1	        1 2 3 4 5

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

//        int[] arr = {5, 4, 3, 2, 1};

        int start = 0;
        int end = arr.length - 1;

        mergeSort(arr, start, end);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {

        if(start >= end) {
            return;
        }

        int middle = (start + end) / 2;

        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);
        mergeSort(arr, start, middle, end);

    }

    private static void mergeSort(int[] arr, int start, int middle, int end) {
        if (arr[middle] < arr[middle + 1]) {
            return;
        }
        int left = start;
        int right = middle + 1;

        int[] helper = new int[arr.length];

        System.arraycopy(arr, 0, helper, 0, arr.length);

        for (int i = start; i <= end ; i++) {
            if (left > middle) {
                arr[i] = helper[right++];
            } else if (right > end) {
                arr[i] = helper[left++];
            } else if (helper[left] < helper[right]) {
                arr[i] = helper[left++];
            } else if (helper[right] < helper[left]) {
                arr[i] = helper[right++];
            }
        }
    }
}
