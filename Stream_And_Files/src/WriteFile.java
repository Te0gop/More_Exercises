import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WriteFile {
    /*
    Read the file named "input.txt" that is provided for this exercise and write all its content to a file while
     skipping any punctuation. Skip the following symbols: ',', '.', '!', '?'.
Submit in Judge only the output of the program.
Examples
Input	                                         Output
On January 1 , 1533 , Michael Angelo, then
fifty-seven years old, writes	                 On January 1 1533  Michael Angelo then fifty-seven years old writes

     */
    public static void main(String[] args) throws IOException {

//        File file = new File("C:\\Users\\Teodor\\StreamAndFiles\\File.txt");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        Scanner scan = new Scanner(fileInputStream);
//
//        StringBuilder builder = new StringBuilder();
//
//        String line = scan.nextLine();
//
//        while(line != null) {
//            builder.append(line.replaceAll("[,\\.!\\?]", ""))
//                .append(System.lineSeparator());
//
//            try {
//                line = scan.nextLine();
//            } catch (NoSuchElementException e) {
//                fileInputStream.close();
//                break;
//            }
//        }
//        System.out.println(builder.toString());
//        OutputStream outputStream = new FileOutputStream("Output.txt");
//        PrintWriter printWriter = new PrintWriter(outputStream);
//        printWriter.print(builder);
//        printWriter.flush();


        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try(InputStream inputStream = new FileInputStream("C:\\Users\\Teodor\\StreamAndFiles\\File.txt");
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Teodor\\StreamAndFiles\\Output.txt")) {
                int oneByte = 0;
                while((oneByte = inputStream.read()) >= 0) {
                    if(!symbols.contains((char) oneByte)) {
                        outputStream.write(oneByte);
                    }
                }
            } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Path path = Path.of("Output.txt");
        byte[] bytes = Files.readAllBytes(path);
//        String str = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println(str);
        String str = new String(bytes);
        System.out.println(str);


    }
}
