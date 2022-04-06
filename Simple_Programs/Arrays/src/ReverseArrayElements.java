import java.util.Arrays;

public class ReverseArrayElements {
    // Write an array program to reverse array.

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 6, 7, 8, 9 };
        int size = arr.length;
        System.out.println("Length of array is " + size);
        int[] rev = new int[size];
        for (int i = 0; i < size; i++) {
            rev[i] = arr[size - 1 - i];
        }
        System.out.println("Actual array is " + Arrays.toString(arr));
        System.out.println("Reverse array is " + Arrays.toString(rev));
    }
}
