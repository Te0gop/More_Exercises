import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    /*
    Read the file provided, named "input.txt" and sort all lines. Write text to another text file. Use Path and Files Classes.

Examples
Input	Output
C       A
A       B
B       C
D	    D
     */

    public static void main(String[] args) throws IOException {
        String fileName = "File.txt";
        List<String> allLines = Files.readAllLines(Paths.get(fileName))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get("Sorted-lines.txt"), allLines);


    }
}
