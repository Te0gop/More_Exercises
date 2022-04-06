public class ExceptionExample7 {
    // Write a program to show exception in java (handelling exception)

    public static void main(String[] args) {
        try {
            System.out.println("No exception there");
            System.out.println("Again No exception there");
            System.out.println("Again and again No exception there");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally block");
        }
        System.out.println("Main Method ");
    }
}
