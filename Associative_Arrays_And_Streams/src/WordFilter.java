import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordFilter {

    // Read an array of strings, take only words which length is even. Print each word on a new line.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(" ");

        Arrays.asList(line)
                .stream()
                .filter(x -> x.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
