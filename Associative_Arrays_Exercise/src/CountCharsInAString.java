import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    /*
    Write a program, which counts all characters in a string except space (' ').
    Print all occurrences in the following format:
        {char} -> {occurrences}
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<Character, Integer> map = new LinkedHashMap<>();

        char[] charArray = input.toCharArray();

        for(char c : charArray) {
            if(c != ' ') {
                if(map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.putIfAbsent(c, 1);
                }
            }
        }

        for(Map.Entry<Character, Integer> elements : map.entrySet()) { // first way
            System.out.println(elements.getKey() + " -> " + elements.getValue());
        }

//        map.forEach((k, v) -> System.out.println(k + " -> " + v)); // second way

//        map
//                .entrySet() // third way
//                .stream()
//                .forEach(x -> System.out.println(x.getKey() + " -> " + x.getValue()));

    }
}
