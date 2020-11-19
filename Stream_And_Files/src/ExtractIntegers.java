import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    /*
    Read the file provided, named "input.txt" and extracts all integers that are not a part of a word in a separate file.
    A valid integer is surrounded with white spaces.

Examples
Input	                                                                         Output
On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes
	                                                                             1
                                                                                 1533
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("File.txt");
        Scanner scanner = new Scanner(file);

        PrintWriter writer = new PrintWriter("Integers.txt");
        while(scanner.hasNext()) {
            if(scanner.hasNextInt()) {
                int nextInt = scanner.nextInt();
                writer.println(nextInt);
            } else {
                scanner.next();
            }
        }
        writer.flush();
    }
}
