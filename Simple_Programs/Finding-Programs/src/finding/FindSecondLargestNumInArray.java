package finding;

public class FindSecondLargestNumInArray {
    // Write a program to find second-largest element in array.

    public static void main(String[] args) {
        int[] a = {23, 4, 55, 23, 45, 65, 223, 121, 43, 675};
        System.out.println("Second largest number is " + getSecondLargest(a));
    }

    public static int getSecondLargest(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[arr.length - 2];
    }
}
