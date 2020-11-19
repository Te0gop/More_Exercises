public class ExampleVarArgs {
    public static void main(String[] args) {

        printVarArgs("String", "Integer", "Char", "Double");
        printVarArgs(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        printVarArgs('c', 'h', 'a', 'r');
        printVarArgs(3.14, 0.1, 15.7);
        printVarArgs();


    }
    @SafeVarargs
    public static <T> void printVarArgs(T... args) { // variable arguments (var args)
        if (args.length == 0) {
            System.out.println("No elements");
        } else {
            for (T s : args) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
