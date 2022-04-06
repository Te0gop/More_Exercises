public class DuplicateElementsInArray {
    // Write an array program in java to find duplicate elements in array.

    public static void main(String[] args) {
        int[] a = { 1, 4, 5, 6, 7, 8, 3, 1, 4, 5 };
        duplicateElements(a);

    }

    public static void duplicateElements(int[] a) {
        System.out.println("Duplicate Elements are...");
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j])
                    System.out.print(a[i] + " ");
            }
        }
    }
}
