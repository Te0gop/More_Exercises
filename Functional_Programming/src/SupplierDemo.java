import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Empty input";

        List<String> input = new ArrayList<>();

        input.add("A");
        input.add("B");
        input.add("C");

        Predicate<String> validator = str -> str.length() >= 2;

        String result = input
                .stream()
                .filter(validator)
                .findFirst()
                .orElse(supplier.get());

        System.out.println(result);
    }
}
