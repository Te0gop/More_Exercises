package finding;

public class FindSmallestAndLargestNumInArray {
    // Write a program to find smallest and largest number in array.

    public static void maxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        System.out.println("Maximum of value is " + maxValue);
    }

    public static void minValue(int[] arr) {
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        System.out.println("Minimum of  value is " + minValue);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 1, 52, 12, 5 };
        maxValue(arr);
        minValue(arr);
    }
}
