import java.io.File;

public class ListFiles {
    /*
    You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes (in bytes)
     of all files that are placed directly in it (do not include files in nested folders).
Submit in Judge only the output of the program.
     */
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Teodor\\StreamAndFiles");

        File[] files = file.listFiles();

        for (File f : files) {
            if(!f.isDirectory()) {
                System.out.println(f.getName() + ": " + "[" + f.length() + "]");
            }
        }

    }
}
