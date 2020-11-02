import java.util.Scanner;

public class RepeatString {
    /*
    Write a method that receives a string and a repeat count n (integer). The method should return a new string
    (the old one repeated n times).
Example
Input	  Output
abc
3	      abcabcabc

String
2	      StringString
     */

    public static String repeat(String word, int num) {
            return word;
    }

    public static void repeatWord(String word, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(repeat(word, num));
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();
        int numberOfRepeats = Integer.parseInt(scan.nextLine());
        repeatWord(word, numberOfRepeats);
    }
}
