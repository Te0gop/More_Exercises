import java.util.Scanner;

public class Orders {
    /*
    Write a method that calculates the total price of an order and prints it on the console. The method should receive
    one of the following products: coffee, water, coke, snacks; and a quantity of the product. The prices for a single
    piece of each product are:
•	coffee – 1.50
•	water – 1.00
•	coke – 1.40
•	snacks – 2.00
Print the result rounded to the second decimal place.
Example:
Input	      Output
water
5	          5.00
coffee
2	          3.00

     */

    public static void calculateOrder(String product, double number) {
        switch (product) {
            case "coffee":
                System.out.printf("%.2f", number * 1.50);
                break;
            case "water":
                System.out.printf("%.2f", number * 1.00);
                break;
            case "coke":
                System.out.printf("%.2f", number * 1.40);
                break;
            case "snacks":
                System.out.printf("%.2f", number * 2.00);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        double number = Double.parseDouble(scan.nextLine());
        calculateOrder(product, number);

    }
}
