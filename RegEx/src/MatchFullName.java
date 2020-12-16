import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    /*
    Write a Java Program to match full names from a list of names and print them on the console.

    Match ALL of these	            Match NONE of these
    Ivan Ivanov	                    ivan ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Ivan IvAnov, Ivan	Ivanov

     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(names);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }

    }
}
