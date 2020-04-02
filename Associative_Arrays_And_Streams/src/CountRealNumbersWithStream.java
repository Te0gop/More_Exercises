import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbersWithStream {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> counts = new TreeMap<>();

        for (Double num : numbers) {
            if(!counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            }
            counts.put(num, 1);
        }
        for(Map.Entry<Double, Integer> entry : counts.entrySet()) {
            DecimalFormat df = new DecimalFormat("#");
            System.out.printf(df.format(entry.getKey()) + " -> " + entry.getValue() + "%n");
        }

    }
}
