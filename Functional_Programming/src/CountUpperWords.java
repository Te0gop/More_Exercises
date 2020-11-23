import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
/*
3.	Count Uppercase Words
Write a program that reads one line of text from the console. Print the count of words that start with a Uppercase
 letter, after that print all these words in the same order, like you found them in the text.
Use a Predicate<String>

 */

public class CountUpperWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Predicate<String> startsWithCapital = str -> Character.isUpperCase(str.charAt(0));
        StringBuilder out = new StringBuilder();

        AtomicInteger counter = new AtomicInteger(0);

        Consumer<String> addToOutput = str -> {
            counter.incrementAndGet();
            out.append(str).append(System.lineSeparator());
        };

        Arrays.stream(text.split("\\s+"))
                .filter(startsWithCapital)
                .forEach(addToOutput);

        System.out.println(counter.get());
        System.out.println(out.toString());
    }
}
