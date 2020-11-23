import java.util.List;
import java.util.Scanner;

public class LambdaDemo {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(13, 43, 56, 73, 100);
        numbers
                .stream()
                .filter(num -> num >= 50) // anonymous lambda
                .forEach(System.out::println);


    }
}
