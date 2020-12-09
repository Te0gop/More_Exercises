package task_02_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*
    Using the ListyIterator from the last problem, extend it by implementing the "Iterable" interface, implement all methods desired by the interface manually. Add a new method to the class PrintAll(), the method should foreach the collection and print all elements on a single line separated by a space.
Input
Input will come from the console as lines of commands. The first line will always be the Create command in the input. The last command received will always be the END command.
Output
For every command from the input (with the exception of the END and Create commands) print the result of that command on the console, each on a new line. In case of Move or HasNext commands print the returned value of the method, in case of a Print command you don’t have to do anything additional as the method itself should already print on the console. In case of a PrintAll command you should print all elements on a single line separated by spaces. Your program should catch any exceptions thrown because of validations and print their messages instead.
Input	                     Output
Create 1 2 3 4 5             true
Move                         1 2 3 4 5
PrintAll
END

     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        ListyIterator listyIterator = null;

        while (!(line = reader.readLine()).equals("END")) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    listyIterator = new ListyIterator(Arrays.stream(tokens).skip(1).toArray(String[]::new));
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
        }
    }
}
