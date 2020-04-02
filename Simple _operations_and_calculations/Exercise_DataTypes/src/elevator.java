import java.util.Scanner;

        import static java.lang.Math.ceil;

public class elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int numOfPeople = scan.nextInt();
        int capacity = scan.nextInt();
        int courses = (int) Math.ceil((double) numOfPeople / capacity);
        System.out.println(courses);

    }
}
