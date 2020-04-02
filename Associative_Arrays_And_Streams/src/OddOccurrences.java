import java.util.*;

public class OddOccurrences {
    /*
    Write a program that extracts from a given sequence of words all elements that are present in it an odd number
    of times (case-insensitive).
        •	Words are given in a single line, space separated
        •	Print the result elements in lowercase in their order of appearance
        Input	                             Output
        Java C# PHP PHP JAVA C java	         java, c#, c
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().toLowerCase().split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < line.length; i++) {
            if(!map.containsKey(line[i])) {
                map.put(line[i], 1);
            } else {
                map.put(line[i], map.get(line[i])+1);
            }
        }

        List<String> oddOccurrences = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                oddOccurrences.add(entry.getKey());
            }
        }

        System.out.printf(String.join(", ", oddOccurrences));


    }
}
