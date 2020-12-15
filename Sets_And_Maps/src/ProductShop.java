import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductShop {
    /*
    Write a program that prints information about food shops in Sofia and the products they store.
    Until the "Revision" command you will receive an input in the format: "{shop}, {product}, {price}"
Take in mind that if you receive a shop you already have received, you must collect its product information.
Your output must be ordered by shop name and must be in the format:
{shop}->
Product: {product}, Price: {price}
The price should be formated to one digit after the decimal point.

Examples
Input	                        Output
lidl, juice, 2.30               fantastico->
fantastico, apple, 1.20         Product: apple, Price: 1.2
kaufland, banana, 1.10          Product: grape, Price: 2.2
fantastico, grape, 2.20         kaufland->
Revision                        Product: banana, Price: 1.1
                                lidl->
                                Product: juice, Price: 2.3
     */
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    TreeMap<String, LinkedHashMap<String, Double>> foodStores = new TreeMap<>();

    String line;

    while(!(line = scanner.nextLine()).equals("Revision")) {

        String shop = line.split(", ")[0];
        String product = line.split(", ")[1];
        Double price = Double.parseDouble(line.split(", ")[2]);

        if (foodStores.containsKey(shop)) {
            foodStores.get(shop).put(product, price);
        } else {
            foodStores.put(shop, new LinkedHashMap<>()  ); //{{put (product,price);}}
        }
        foodStores.get(shop).put(product, price);
    }

//            foodStores.forEach((key, value) -> {
//                System.out.println(key + "->");
//                value.forEach((innerKey, innerValue) -> {
//                    System.out.printf("Product: %s, Price: %s%n", innerKey, innerValue);
//                });
//            });

        for (Map.Entry<String, LinkedHashMap<String, Double>> key : foodStores.entrySet()) {
            System.out.println(key.getKey() + "->");
            for (Map.Entry<String, Double> s : key.getValue().entrySet()) {
                System.out.println("Product: " + s.getKey() + ", Price: " + s.getValue());
            }
        }
    }
}
