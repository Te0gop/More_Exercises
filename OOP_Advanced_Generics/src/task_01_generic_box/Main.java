package task_01_generic_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
Create a generic class Box that can store any type. Override the toString() method to print the type and the value of
the data stored in the format {class full name: value}.
Use the class that you've created and test it with the class java.lang.String. On the first line you will get n - the
number of strings to read from the console. On the next n lines, you will get the actual strings. For each of them
create a box and call its toString() method to print its data on the console.

Examples:
   Input                                 Output
2                           java.lang.String: life in a box
life in a box               java.lang.String: box in a life
box in a life
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countOfBoxes = Integer.parseInt(bufferedReader.readLine());

        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < countOfBoxes; i++) {
            String input = bufferedReader.readLine();

            Box<String> box = new Box<>();
            box.setValue(input);
            boxes.add(box);
        }

        boxes.forEach(System.out::println);


    }



}
