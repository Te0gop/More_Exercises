import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String line;

        while (!(line = scanner.nextLine()).equals("end")) {

            String[] delimiter = line.split(" ");
            String command = delimiter[0];
            switch (command) {
                case "swap":
                    int firstIndex = Integer.parseInt(delimiter[1]);
                    int secondIndex = Integer.parseInt(delimiter[2]);
                    int swap = 0;
                    swap = arr[firstIndex];
                    arr[firstIndex] = arr[secondIndex];
                    arr[secondIndex] = swap;
                    break;
                case "multiply":
                    int first = Integer.parseInt(delimiter[1]);
                    int second = Integer.parseInt(delimiter[2]);
                    arr[first] *= arr[second];
                    break;
                case "decrease":
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] -= 1;
                    }
                    break;
            }
        }
        String modifiedArr = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(modifiedArr);
    }
}
