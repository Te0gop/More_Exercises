public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {1, 4, -1, 10, 52, 13, 40, 60};

        sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {

        mergeSort(arr, 0, arr.length - 1);

    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
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
