public class ExceptionExample {
    // Write a program to show exception in java (Arithmetic divide by zero)

    public static void main(String[] args) {
        try {
            System.out.println("No exception there");
            System.out.println("Again no exception There");
            System.out.println("Again and again No exception there");
        } catch (Throwable e) {

            System.out.println(10 / 0);

        } finally {
            System.out.println(10 / 0);
            System.out.println("Finally block");
        }
        System.out.println("Main Method ");
    }
}
