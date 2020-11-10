import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    /*
    We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
Print the result back at the terminal.
Examples
Input	                                   Output
1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5	       (2 + 3)
                                           (3 + 1)
                                           (2 - (2 + 3) * 4 / (3 + 1))

(2 + 3) - (2 + 3)	                       (2 + 3)
                                           (2 + 3)

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();

        String delimiter = scan.nextLine();

        for (int i = 0; i < delimiter.length(); i++) {
            char ch = delimiter.charAt(i);

            if(ch == '(') {
                stack.push(i);
            } else if(ch == ')') {
                int startIndex = stack.pop();
                String contents = delimiter.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}
