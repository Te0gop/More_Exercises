import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    /*
    Write a program that reads a list of integers. Then until you receive "end", you will be given different commands:
Add {number}: add a number to the end of the list
Remove {number}: remove a number from the list
RemoveAt {index}: remove a number at a given index
Insert {number} {index}: insert a number at a given index
Note: All the indices will be valid!
When you receive the "end" command print the final state of the list (separated by spaces)
Example
Input	                 Output
4 19 2 53 6 43
Add 3
Remove 2
RemoveAt 1
Insert 8 3
end	                      4 53 6 8 43 3

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        List<Integer> list = new ArrayList<>();
//
//        String[] numbers = scan.nextLine().split("\\s+");
//
//        for (String number : numbers) {
//            list.add(Integer.parseInt(number));
//        }

        List<Integer> list = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while(true) {
            String[] command = scan.nextLine().split(" ");
            if(command[0].equals("end")) {
                break;
            }

            switch (command[0]) {
                case "Add":
                    list.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(command[1]));
                    break;
                case "RemoveAt":
                    list.remove(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    list.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                    break;
            }

        }
        for (Integer elements : list) {
            System.out.print(elements + " ");
        }


    }
}
