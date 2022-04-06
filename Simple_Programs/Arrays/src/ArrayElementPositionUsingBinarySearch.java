import java.util.Arrays;
import java.util.Scanner;

public class ArrayElementPositionUsingBinarySearch {
    // Write an array program in java to sort the array element and search an element using binary search.

    public static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == arr[mid]) {
                return mid;
            }
            if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter array elements ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("After sorting elements are :");
        for (int a : arr) {
            System.out.println(a);
        }
        System.out.println("Enter key value");
        int k = sc.nextInt();
        System.out.println("element position is on index number is " + binarySearch(arr, k));
    }
}
