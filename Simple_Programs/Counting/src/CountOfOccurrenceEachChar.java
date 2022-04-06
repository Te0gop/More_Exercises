import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CountOfOccurrenceEachChar {
    // Write a program in Java to count the occurrence each character.

    public static void main(String[] args) {

        String str = "Learn Java Coding";
        countOfOccurrences(str);
    }

    private static void countOfOccurrences(String str) {
        char[] ch = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character c : ch) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> s = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> itr = s.iterator();

        while (itr.hasNext()) {
            Map.Entry<Character, Integer> entry = itr.next();
            System.out.println(entry.getKey() + "------" + entry.getValue());
        }
    }
}
