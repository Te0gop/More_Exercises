import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    /*
    Write a program that reads some text from the console and counts the occurrences of each character in it.
    Print the results in alphabetical (lexicographical) order.
    Examples:
    Input:                 Output:
    Never mind.                : 1 time/s
                               .: 1 time/s
                               N: 1 time/s
                               d: 1 time/s
                               e: 2 time/s
                               i: 1 time/s
                               m: 1 time/s
                               n: 1 time/s
                               r: 1 time/s
                               v: 1 time/s
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String symbols = scanner.nextLine();

        Map<Character, Integer> mapOfSymbols = new TreeMap<>();

        for (int i = 0; i < symbols.length(); i++) {

            char symbol = symbols.charAt(i);

            if (!mapOfSymbols.containsKey(symbol)) {
                mapOfSymbols.put(symbol, 1);
            } else {
                mapOfSymbols.put(symbol, mapOfSymbols.get(symbol) + 1);
            }
        }

        for(Map.Entry<Character, Integer> elements : mapOfSymbols.entrySet()) {
            System.out.println(elements.getKey() + ": " + elements.getValue() + " time/s");
        }
    }
}
