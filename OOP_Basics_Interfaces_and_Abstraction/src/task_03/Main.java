package task_03;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {

        Scanner scan = new Scanner(System.in);
        String driver = scan.nextLine();
        Ferrari car = new Ferrari(driver);

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
        System.out.println(car);

    }
}
