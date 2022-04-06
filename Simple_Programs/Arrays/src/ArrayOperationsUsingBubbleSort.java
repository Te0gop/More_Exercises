import java.util.Scanner;

public class ArrayOperationsUsingBubbleSort {
    // Write a program in java to perform array operation using bubble sort.

    public static void bubbleSort(int[] a, int n) {

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j <= n - 2 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("After Sorting elements are  ");
        for (int b : a) {
            System.out.println(b);
        }
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

        bubbleSort(arr, len);
        System.out.println("smallest element is :" + arr[0]);
        System.out.println("largest element is :" + arr[len - 1]);
        System.out.println("Enter which element you want");
        int k = sc.nextInt();
        for (int i = 0; i < len; i++) {
            if (k == arr[i]) {
                System.out.println("element is found in " + k + "th position");
            } else {
                System.out.println("element is not found");
            }
        }
    }
}
