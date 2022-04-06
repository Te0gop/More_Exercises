package finding;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateNumbers {
    // Write a program to find duplicate numbers in java.

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(5);
        list.add(2);
        findDuplicates(list);
        System.out.println();
    }

    private static void findDuplicates(List<Integer> list) {
        List<Integer> listWithoutDuplicates = new ArrayList<>();
        System.out.println("duplicate list is " + list);
        System.out.println("duplicate elements are  ");
        for (int i : list) {
            if (listWithoutDuplicates.contains(i)) {
                System.out.print(i + " ");
            } else {
                listWithoutDuplicates.add(i);
            }
        }
    }
}
