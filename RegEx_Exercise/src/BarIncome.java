import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;

        Map<String, Map<String, Double>> map = new LinkedHashMap<>();

        while(!(line = scanner.nextLine()).equals("end of shift")) {
            Pattern pattern =
                    Pattern.compile("%(?<name>[A-Z][a-z]+)%[^$.|%]*?<(?<product>\\w+)>[^$.|%]*?\\|(?<count>\\d+)\\|[^$.|%]*?(?<price>\\d+(\\.\\d+)?)\\$");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                if (name != null && product != null && count != 0 && price != 0) {
                    map.put(name, new LinkedHashMap<>() {{put(product, count * price);}});
                }
            }
        }


        map.forEach((key, value) -> value.forEach((innerKey, innerValue) -> {
            System.out.printf("%s: %s - %.2f%n", key, innerKey, innerValue);
            //sum += innerValue;
        }));

        double sum = 0;
        for (Map.Entry<String, Map<String, Double>> key : map.entrySet()) {
            for (Double s : key.getValue().values()) {
                sum += s;
            }
        }

        System.out.printf("Total income: %.2f", sum);

    }
    //private static double sum = 0;
}
