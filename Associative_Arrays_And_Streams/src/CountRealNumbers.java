
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*
 Read a list of real numbers and print them in ascending order along with their number of occurrences.
 */
public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(" ");
        Double[] numbers = new Double[line.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Double.parseDouble(line[i]);
        }
        Map<Double, Integer> map = new TreeMap<>();

        for (Double number : numbers) {
            if(map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        for(Map.Entry<Double, Integer> entry : map.entrySet()) {
            DecimalFormat df = new DecimalFormat("#");
            System.out.printf(df.format(entry.getKey()) + " -> " + entry.getValue() + "%n");
        }


    }
}
