import java.util.*;

public class PeriodicTable {
    /*
    You are given an n number of chemical compounds. You need to keep track of all chemical elements used
    in the compounds and at the end print all unique ones in ascending order:
Examples
Input	      Output
4             Ce Ee Mo O
Ce O
Mo O Ce
Ee
Mo
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            Collections.addAll(chemicalElements, elements);
        }

        for (String element : chemicalElements) {
            System.out.print(element + " ");
        }
        //System.out.println(String.join(" ", chemicalElements));




    }
}
