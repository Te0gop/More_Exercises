package finding;

public class FindSecondSmallestNumInArray {
    // Write a program to find second-smallest number in array.

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 2, 3, 561, 335, 121, 3241, 1231, 12, 1, 12};
        System.out.println("Second Smallest NUmber is " + getSecondSmallestNumber(arr));
    }

    public static int getSecondSmallestNumber(int[] arr) {
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
