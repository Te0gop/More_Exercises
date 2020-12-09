package task_03_stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*
    Since you have passed the basics algorithms course, now you have a task to create your custom stack. You are aware of the Stack structure. There is a collection to store the elements and two functions (not from the functional programming) - to push an element and to pop it. Keep in mind that the first element which is popped is the last in the collection. The push method adds an element to the top of the collection and the pop method returns the top element and removes it.
Write your custom implementation of Stack<Integer> and implement your custom iterator. There is a way that IntelliJ could help you, your Stack class should implement the "Iterable<Integer>" interface and your Iterator Class should implement "Iterator<Integer>" interface. Your Custom Iterator should follow the rules of the Abstract Data Type - Stack. Like we said, the first element is the element at the top and so on. Iterators are used only for iterating through the collection, they should not remove or mutate the elements.
Input
The input will come from the console as lines of commands. Commands will only be push and pop, followed by integers for the push command and no another input for the pop command.
Format:
•	"Push {element, secondElement…}"
•	"Pop"
Output
When you receive "END", the input is over. Foreach the stack twice and print all elements. Each element should be on a new line.
Input	                  Output
Push 1, 2, 3, 4           2
Pop                       1
Pop                       2
END	                      1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        Stack stack = new Stack();

        while (!(line = reader.readLine()).equals("END")) {
            line = line.replaceAll(",", "");
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Push":
                    stack.push(Arrays.stream(tokens)
                            .skip(1)
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .toArray(Integer[]::new));
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
        }

        stack.forEach(System.out::println);

        for (Integer integer : stack) {
            System.out.println(integer);
        }






    }
}
