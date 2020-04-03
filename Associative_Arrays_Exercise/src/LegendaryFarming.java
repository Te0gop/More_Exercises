import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    /*
    You've beaten all the content and the last thing left to accomplish is own a legendary item. However, it's a
    tedious process and requires quite a bit of farming.
Anyway, you are not too pretentious - any legendary will do. The possible items are:
    •	Shadowmourne - requires 250 Shards
    •	Valanyr - requires 250 Fragments
    •	Dragonwrath - requires 250 Motes
Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as
"2 motes 3 ores 15 stones". Keep track of the key materials - the first that reaches the 250 mark wins the race.
At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes,
ordered by quantity in descending order, then by name in ascending order, each on a new line. Finally, print the
collected junk items, in alphabetical order.
    Input
    •	Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}
    Output
    •	On the first line, print the obtained item in format {Legendary item} obtained!
    •	On the next three lines, print the remaining key materials in descending order by quantity
    o	If two key materials have the same quantity, print them in alphabetical order
    •	On the final several lines, print the junk items in alphabetical order
    o	All materials are printed in format {material}: {quantity}
    o	All output should be lowercase, except the first letter of the legendary
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> specialItems = new TreeMap<>();
        Map<String, Integer> junkItems = new TreeMap<>();

        specialItems.put("shards", 0);
        specialItems.put("fragments", 0);
        specialItems.put("motes", 0);

        boolean isObtained = false;
        while(!isObtained) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");

            for (int i = 0; i < tokens.length ; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String item = tokens[i+1].toLowerCase();
                if(specialItems.containsKey(item)) {
                    specialItems.put(item, specialItems.get(item) + quantity);
                } else {
                    if(!junkItems.containsKey(item)) {
                        junkItems.put(item, quantity);
                    } else {
                        junkItems.put(item, junkItems.get(item) + quantity);
                    }
                }
                if(specialItems.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    specialItems.put("shards", specialItems.get("shards") - 250);
                    isObtained = true;
                    break;
                } else if (specialItems.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    specialItems.put("fragments", specialItems.get("fragments") - 250);
                    isObtained = true;
                    break;
                } else if (specialItems.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    specialItems.put("motes", specialItems.get("motes") - 250);
                    isObtained = true;
                    break;
                }
            }
        }
        specialItems
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        junkItems
                .forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
