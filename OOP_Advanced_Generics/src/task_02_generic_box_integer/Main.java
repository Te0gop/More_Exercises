package task_02_generic_box_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countOfBoxes = Integer.parseInt(bufferedReader.readLine());

        List<Box<Integer>> boxes = new ArrayList<>();

        for (int i = 0; i < countOfBoxes; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());

            Box<Integer> box = new Box<>();
            box.setValue(input);
            boxes.add(box);
        }

        boxes.forEach(System.out::println);


    }



}
