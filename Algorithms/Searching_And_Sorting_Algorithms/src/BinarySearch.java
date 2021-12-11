import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    //Implement an algorithm that finds the index of an element in a sorted array of integers in logarithmic time
    //Examples
    //Input	            Output	            Comments
    //1 2 3 4 5         0                   Index of 1 is 0
    //1

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
        int[] arr = {1, 2, 3, 4, 5};

//        int indexOf = Integer.parseInt(scanner.nextLine());
        int indexOf = 2;

        System.out.println(binarySearch(arr, indexOf));

    }

    private static int binarySearch(int[] arr, int indexOf) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if(indexOf < arr[middle]) {
                end = middle - 1;
            } else if (indexOf > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
