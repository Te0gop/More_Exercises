public class PermutationsWithoutRepetitions {
//Given a set of elements, find all permutations without repetitions.
//Examples
//Input	        Output
//A B C	        A B C
//              A C B
//              B A C
//              B C A
//              C B A
//              C A B
    public static String[] elements = {"A", "B", "C"};

    public static void main(String[] args) {
        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }

        permute(index + 1);
        for (int i = index + 1; i < elements.length; i++) {
            swap(elements, index, i);
            permute(index + 1);
            swap(elements, index, i);
        }

    }

    private static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
