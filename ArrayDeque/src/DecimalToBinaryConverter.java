import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    /*
    Create a simple program that can convert a decimal number to its binary representation. Implement an elegant
    solution using a Stack.
Print the binary representation back at the terminal.
Examples
Input	     Output
10	         1010
1024	     10000000000
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int num = number;
        Deque<Integer> stack = new ArrayDeque<>();

        while(number != 0) {
            stack.push(number % 2);
            number /= 2;
        }

        if(num == 0) {
            System.out.println(0);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }


    }
}
