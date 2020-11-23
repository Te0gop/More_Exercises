import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {

        Function<Integer, Integer> squared = x -> x * x;
        Function<Integer, Integer> multiplyByThree = x -> x * 3;

        Integer result = squared.compose(multiplyByThree).apply(4);

        System.out.println(result);
    }
}
