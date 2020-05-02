package task_04_generic_swap_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countOfBoxes = Integer.parseInt(bufferedReader.readLine());

        List<Box<Integer>> boxes = new ArrayList<>();

        for (int i = 0; i < countOfBoxes; i++) {
            Integer input = Integer.parseInt(bufferedReader.readLine());

            Box<Integer> box = new Box<>();
            box.setValue(input);
            boxes.add(box);
        }
        int[] indexes = Stream.of(bufferedReader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        swap(boxes, indexes[0], indexes[1]);

        boxes.forEach(System.out::println);
    }
    public static <T> void swap(List<Box<T>> boxes, int firstIndex, int secondIndex) {
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
    }


}
