public class ExceptionExample6 {
    //Write a program to show exception in java (Arithmetic)
    public static void main(String[] args) {
        doWork();
    }

    public static void doWork() {
        doMoreWork();
        System.out.println(10 / 0);
    }

    public static void doMoreWork() {
        System.out.println("hello");
    }
}
