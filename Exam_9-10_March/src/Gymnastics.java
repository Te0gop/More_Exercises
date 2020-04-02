import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String country = scan.nextLine();
        String item = scan.nextLine();

        double difficulty = 0;
        double performance = 0;

        if ("ribbon".equals(item)) {
            switch (country) {
                case "Russia":
                    difficulty += 9.100;
                    performance += 9.400;
                    break;
                case "Bulgaria":
                    difficulty += 9.600;
                    performance += 9.400;
                    break;
                case "Italy":
                    difficulty += 9.200;
                    performance += 9.500;
                    break;
            }
        }
        else if ("hoop".equals(item)) {
            switch (country) {
                case "Russia":
                    difficulty += 9.300;
                    performance += 9.800;
                    break;
                case "Bulgaria":
                    difficulty += 9.550;
                    performance += 9.750;
                    break;
                case "Italy":
                    difficulty += 9.450;
                    performance += 9.350;
                    break;
            }
        }
        else if ("rope".equals(item)) {
            switch (country) {
                case "Russia":
                    difficulty += 9.600;
                    performance += 9.000;
                    break;
                case "Bulgaria":
                    difficulty += 9.500;
                    performance += 9.400;
                    break;
                case "Italy":
                    difficulty += 9.700;
                    performance += 9.150;
                    break;
            }
        }
        double grade = difficulty + performance;
        double percentNeeded = (20 - grade) / 20 * 100;

        System.out.printf( "The team of %s get %.3f on %s.%n", country, grade, item);
        System.out.printf("%.2f%%", percentNeeded);

    }
}
