public class ShowException {
    // Write a program to show exception in java (Arithmetic)

    public static void main(String[] args) {
        try {
            System.out.println("No exception there");
            System.out.println(10 / 0);
            System.out.println("Again and again No exception there");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        } finally {
            System.out.println("Finally Block");
        }
        System.out.println("Main Method ");
    }
}
