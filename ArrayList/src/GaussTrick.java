import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    /*
    Write a program that sum all numbers in a list in the following order:
first + last, first + 1 + last - 1, first + 2 + last - 2, … first + n, last - n.

Example
Input	        Output
1 2 3 4 5	    6 6 3
1 2 3 4	        5 5

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split("\\s+");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        for (int i = 0; i < arr.length / 2; i++) {
            list.set(i, list.get(i) + i + list.get(list.size() - i - 1));
            list.remove(list.size()-1);
        }

        for (Integer el : list) {
            System.out.print(el + " ");
        }

    }
}
