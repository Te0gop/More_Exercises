import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals {
    /*
    Write a program that reads a text file (input.txt from the Resources - Exercises)  and changes the casing of
    all letters to upper. Write the output to another file (output.txt).
     */
    public static void main(String[] args) throws IOException {


        try(BufferedReader reader = Files.newBufferedReader(Paths.get("src/resources/input.txt"))) {
            String line;
            PrintWriter printWriter = new PrintWriter("src/resources/output.txt");

            while ((line = reader.readLine()) != null) {

                printWriter.println(line.toUpperCase());

            }
            printWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new FileReader("src/resources/output.txt"));

        StringBuilder s = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != null) {
            s.append(line).append("\n");
        }
        System.out.println(s);






    }
}
