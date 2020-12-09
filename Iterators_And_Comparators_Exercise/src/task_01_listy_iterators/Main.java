package task_01_listy_iterators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*
    Create a class "task01_listy_iterators.ListyIterator", it should receive the collection of Strings which it will iterate, through its constructor. You should store the elements in a List. The class should have three main functions:
•	Move - should move an internal index position to the next index in the list, the method should return true if it successfully moved and false if there is no next index.
•	HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
•	Print - should print the element at the current internal index, calling Print on a collection without elements should throw an appropriate exception with the message "Invalid Operation!".
By default, the internal index should be pointing to the 0th index of the List. Your program should support the following commands:

Input	Output
Create Stefcho Goshky       true
HasNext                     Stefcho
Print                       true
Move                        Goshky
Print
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
            }
        }





    }
}
