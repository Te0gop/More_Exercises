package task02_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = ArrayCreator.<Integer>create(Integer.class, 12, 12);
    }
}
