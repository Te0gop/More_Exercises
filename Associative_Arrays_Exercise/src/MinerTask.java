import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    /*
    Until you receive "stop" command, you will be given a sequence of strings, each on a new line.
    Every odd line on the console is representing a resource (e.g. Gold, Silver, Copper, etc.) and every even - quantity.
    Your task is to collect the resources and print them each on a new line.
    Print the resources and their quantities in format: {resource} –> {quantity}
        The quantities inputs will be in the range [1 … 2 000 000 000]
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();

        String line = scan.nextLine();

        while(!line.equals("stop")) {

            int quantity = Integer.parseInt(scan.nextLine());

            if(!map.containsKey(line)) {
                map.put(line, quantity);
            } else {
                map.put(line, map.get(line) + quantity);
            }
            line = scan.nextLine();
        }
        map.forEach((k,v) -> System.out.println(k + " -> "+ v));
    }
}
