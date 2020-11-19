import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {
    /*
    You are given a file named "input.txt". Read and print all of its contents as a sequence of bytes
    (the binary representation of the ASCII code for each character) separated by a single comma.
Submit in Judge only the output of the program.
Examples
Input	                                          Output
On January 1 , 1533 , Michael Angelo,
then fifty-seven years old, writes…	              11101111 10111011 10111111 1001111 1101110 100000 1001010
                                                  1100001 1101110 1110101…
     */
    public static void main(String[] args) throws IOException {
//        Path path = Path.of("File.txt");
//
//        byte[] bytes = Files.readAllBytes(path);
//
//        for (byte b : bytes) {
//            System.out.print(Integer.toBinaryString(b) + " ");
//        }

        try(FileInputStream fileInputStream = new FileInputStream("File.txt")) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
