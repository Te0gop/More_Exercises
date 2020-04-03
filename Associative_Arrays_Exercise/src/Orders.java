import java.util.*;

public class Orders {
    /*
    Write a program, which keeps information about products and their prices. Each product has a name, a price and
    its quantity. If the product doesn't exist yet, add it with its starting quantity.
If you receive a product, which already exists, increase its quantity by the input quantity and if its price is
different, replace the price as well. You will receive products' names, prices and quantities on new lines. Until you
receive the command "buy", keep adding items. When you do receive the command "buy", print the items with their names
and total price of all the products with that name.
    Input
    •	Until you receive "buy", the products come in the format: "{name} {price} {quantity}"
    •	The product data is always delimited by a single space
    Output
    •	Print information about each product, following the format:
    "{productName} -> {totalPrice}"
    •	Format the average grade to the 2nd decimal place
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> orders = new LinkedHashMap<>();
        String line = scanner.nextLine();

        while (!"buy".equals(line)) {
            String[] tokens = line.split(" ");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            double quantity = Double.parseDouble(tokens[2]);

            if (!orders.containsKey(product)) {
                orders.put(product, new ArrayList<>());
                orders.get(product).add(price);
                orders.get(product).add(quantity);
            } else {
                orders.get(product).set(0, price);
                orders.get(product).set(1, orders.get(product).get(1) + quantity);
            }

            line = scanner.nextLine();
        }
        orders.entrySet()
                .stream()
                .forEach(o -> System.out.printf("%s -> %.2f%n", o.getKey(), o.getValue().get(0) * o.getValue().get(1)));
    }
}
