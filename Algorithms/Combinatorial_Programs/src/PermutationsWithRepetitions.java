import java.util.HashSet;

public class PermutationsWithRepetitions {
    //Given a multi-set of elements, find all permutations.
    //Examples
    //Input	        Output
    //A B B	        A B B
    //              B A B
    //              B B A
    public static String[] elements = {"A", "B", "B"};

    public static void main(String[] args) {
        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }

        permute(index + 1);

        HashSet<String> swapped = new HashSet<>();
        swapped.add(elements[index]);

        for (int i = index + 1; i < elements.length; i++) {
            if(!swapped.contains(elements[i])) {
                swap(elements, index, i);
                permute(index + 1);
                swap(elements, index, i);
                swapped.add(elements[i]);
            }
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
