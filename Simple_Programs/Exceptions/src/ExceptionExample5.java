public class ExceptionExample5 {
    // Write a program to show exception in java (show the finally block)
    public static void main(String[] args) {
        try {
            System.out.println("No exception there");
            System.out.println("Again no exception There");
            System.out.println("Again and again No exception there");
        } catch (Exception e) {

            System.out.println("Exception Occurs");

        } finally {
            System.out.println("I am From Finally Block");
        }
        System.out.println(10 / 0);
    }
}
