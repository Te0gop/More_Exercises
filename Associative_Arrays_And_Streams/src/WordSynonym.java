import java.util.*;

public class WordSynonym {
    /*
    Write a program which keeps a map with synonyms. The key of the map will be the word. The value will be a list of
    all the synonyms of that word. You will be given a number n. On the next 2 * n lines you will be given a word
    and a synonym each on a separate line like this:
        •	{word}
        •	{synonym}
    If you get the same word for second time, just add the new synonym to the list. Print the words in the following format:
    {word} - {synonym1, synonym2… synonymN}
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        Map<String, List<String>> map = new LinkedHashMap<>();

        for (int i = 0; i < num ; i++) {
            String key = scan.next();
            String synonym = scan.next();

            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(synonym);

           // map.putIfAbsent(key, new ArrayList<>()); // adding the key if it doesn't exist.
           // map.get(key).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf(entry.getKey() + " - " + String.join(", ", entry.getValue()) + "%n");
        }

    }
}
