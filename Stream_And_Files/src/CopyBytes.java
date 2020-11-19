import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;

public class CopyBytes {
    /*
    Read the file named "input.txt" and write to another file every character's ASCII representation.
Write every space or new line as it is, e.g. as a space or a new line.
Examples
Input	                                      Output
On January 1 , 1533 , Michael Angelo,
then fifty-seven years old, writes
…	                                          79110 749711011797114121 49 44 49535151 44 771059910497101108
                                              6511010310110811144 116104101110 10210510211612145115101118101110
                                              12110197114115 11110810044 119114105116101115
     */
    public static void main(String[] args) throws IOException {
        File file = new File("File.txt");
        byte[] bytes = Files.readAllBytes(file.toPath());

        Writer writer = new FileWriter("Text-as-bytes.txt");
        for (byte b : bytes) {
            String out = String.valueOf(b);
            if(b == 32) { // 32 is space (ASCII table)
                out = " ";
            } else if (b == 10) { // 10 is new line
                out = System.lineSeparator(); // creates new line
            }
            writer.write(out);
            System.out.print(out);
            writer.flush();
        }

    }
}
