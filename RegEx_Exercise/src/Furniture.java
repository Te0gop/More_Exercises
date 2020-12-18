import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    /*
    Write a program to calculate the total cost of different types of furniture. You will be given some lines of
    input until you receive the line "Purchase". For the line to be valid it should be in the following format:
">>{furniture name}<<{price}!{quantity}"
The price can be a floating-point number or a whole number. Store the names of the furniture and the total price.
At the end print each bought furniture on a separate line in the format:
"Bought furniture:
{1st name}
{2nd name}
…"
And on the last line print the following: "Total money spend: {spend money}" formatted to the second decimal point.

Input	                        Output	                                    Comment
>>Sofa<<312.23!3                Bought furniture:                           Only the Sofa and the TV are valid,
>Invalid<<!5                    TV                                          or each of them we multiply the price by
>>TV<<300!5                     Sofa                                        the quantity and print the result
Purchase                        Total money spend: 2436.69
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String furniture;

        Map<String, Map<Double, Integer>> map = new LinkedHashMap<>();

        while(!(furniture = scanner.nextLine()).equals("Purchase")) {

            Pattern pattern = Pattern.compile(">>(?<String>\\w+)<<(?<Float>\\d+([.]\\d+)?)!(?<Integer>\\d+(?!.))");
            Matcher matcher = pattern.matcher(furniture);

            while (matcher.find()) {

                String item = matcher.group("String");
                double price = Double.parseDouble(matcher.group("Float"));
                int quantity = Integer.parseInt(matcher.group("Integer"));

                if (item != null && price != 0 && quantity != 0) {
                    map.put(item, new LinkedHashMap<>() {{put(price, quantity);}});
                }
            }

            double sum = 0;

            for (Map.Entry<String, Map<Double, Integer>> key : map.entrySet()) {
                for (Map.Entry<Double, Integer> s : key.getValue().entrySet()) {
                    sum += s.getKey() * s.getValue();
                }
            }
        }
        double sum = 0;

        System.out.println("Bought furniture:");
        map.forEach((key, value) -> System.out.println(key));

        for (Map.Entry<String, Map<Double, Integer>> key : map.entrySet()) {
            for (Map.Entry<Double, Integer> s : key.getValue().entrySet()) {
                sum += s.getKey() * s.getValue();
            }
        }
        System.out.printf("Total money spend: %.2f", sum);

    }
}
