import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    /*
    Create a simple calculator that can evaluate simple expressions that will not hold any operator different from addition and subtraction. There will not be parentheses or operator precedence.
Solve the problem using a Stack.
Examples
Input	                 Output
2 + 5 + 10 - 2 - 1	     14
2 - 2 + 5	             5
Hints
•	Use an ArrayDeque<>
•	Consider using the add() method
•	You can either
o	add the elements and then pop them out
o	or push them and reverse the stack

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] delimiter = scan.nextLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, delimiter);

        while(stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (op) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
        }
        System.out.println(stack.pop());

    }
}
