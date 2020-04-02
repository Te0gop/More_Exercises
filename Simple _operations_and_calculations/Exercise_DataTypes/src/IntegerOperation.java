import java.util.Scanner;

public class IntegerOperation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = scan.nextInt();
        int secondNum = scan.nextInt();
        int thirdNum = scan.nextInt();
        int fourthtNum = scan.nextInt();
        int result = (firstNum + secondNum) / thirdNum * fourthtNum;
        System.out.println(result);
    }
}
