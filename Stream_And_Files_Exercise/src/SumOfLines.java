import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumOfLines {
    /*
    Write a program that reads a text file (input.txt from the Resources - Exercises) and prints on the console the
    sum of the ASCII symbols of each of its lines. Use BufferedReader in combination with FileReader.

    Input	                     Output
On January 1 , 1533 ,            1452

     */
    public static void main(String[] args) {


        try(BufferedReader reader = Files.newBufferedReader(Paths.get("src/resources/input.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                long sum = 0;

//                for(char c : line.toCharArray()) {
//                    sum += c;
//                }
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
