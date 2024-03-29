import java.util.Scanner;

public class CombinationsWithRepetition {
    //Given a set of elements, generate all combinations of k elements with repetition.
    //Examples
    //Input	        Output
    //A B C         A A
    //2	            A B
    //              A C
    //              B B
    //              B C

    public static String[] elements;
    public static String[] variations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");

        int k = Integer.parseInt(scanner.nextLine());
        variations = new String[k];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if(index == variations.length) {
            print(variations);
        } else {
            for (int i = start; i < elements.length; i++) {
                variations[index] = elements[i];
                combinations(index + 1, i);
            }
        }

    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
