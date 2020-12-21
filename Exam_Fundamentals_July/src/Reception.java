import java.util.Scanner;

public class Reception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        int servicedClientsPerHour = firstEmployee + secondEmployee + thirdEmployee;

        int hoursCounter = 0;
        int fourCount = 0;

        while(students > 0) {

            hoursCounter++;

            if(fourCount < 3) {
                students -= servicedClientsPerHour;
                fourCount++;
            } else {
                fourCount = 0;
            }

            if(students <= 0) {
                break;
            }
        }
        System.out.println("Time needed: " + hoursCounter + "h.");
    }
}
