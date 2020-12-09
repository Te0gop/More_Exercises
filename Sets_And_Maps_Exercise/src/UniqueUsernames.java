import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
Write a simple program that reads from the console a sequence of usernames and keeps a collection with only the
unique ones. Print the collection on the console in order of insertion:

Input	       Output
5
Ivan           Ivan
Ivan           George
Ivan           Martin
George
Martin

 */

public class UniqueUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> names = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            names.add(name);
        }
        for (String name : names) {
            System.out.println(name);
        }

    }
}
