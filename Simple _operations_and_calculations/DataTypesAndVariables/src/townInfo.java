import java.util.Scanner;

public class townInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String town = scan.nextLine();
        int population = scan.nextInt();
        int km = scan.nextInt();

        System.out.printf("Town %s has population of %d and area %d square km.", town, population, km);
    }
}
