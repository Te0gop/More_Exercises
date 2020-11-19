import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    /*
    Write a program that:
•	Records car number for every car that enter in the parking lot
•	Removes car number when the car go out
Input
The input will be string in format [direction, carNumber]
The input ends with string "END"
Output
Print the output with all car numbers which are in parking lot
Examples
Input	            Output
IN, CA2844AA        CA9999TT
IN, CA1234TA        CA2844AA
OUT, CA2844AA       CA9876HH
IN, CA9999TT        CA2822UU
IN, CA2866HI
OUT, CA1234TA
IN, CA2844AA
OUT, CA2866HI
IN, CA9876HH
IN, CA2822UU
END
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> cars = new LinkedHashSet<>();


        while(true) {
            String[] command = scan.nextLine().split(", ");
            if(command[0].equals("END")) {
                break;
            }

            if(command[0].equals("IN")) {
                cars.add(command[1]);
            } else if (command[0].equals("OUT")) {
                cars.remove(command[1]);
            }

        }
        if(cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        for (String car : cars) {
            System.out.println(car);
        }


    }
}
