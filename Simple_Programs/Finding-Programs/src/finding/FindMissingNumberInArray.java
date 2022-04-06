package finding;

public class FindMissingNumberInArray {
    // Write a program to find missing number in array.

    public static void main(String[] args) {
        int n;
        int[] arr = {1, 2, 3, 4, 5, 7};
        n = 7;
        int expectedOutput = n * ((n + 1) / 2);
        int sum = 0;

        for (int i : arr) {
            sum = sum + i;
        }
        int result = expectedOutput - sum;
        System.out.println("Missing Number is " + result);
    }
}
