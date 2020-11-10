import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    /*
    Write a program which takes 2 types of browser instructions:
•	Normal navigation: a URL is set, given by a string
•	The string "back" that sets the current URL to the last set URL
After each instruction the program should print the current URL. If the back instruction can’t be executed, print
"no previous URLs". The input ends with "Home" command, then simply you have to stop the program.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> deque = new ArrayDeque<>();

        String command = scan.nextLine();

        String currentLocation = "";

        while (!command.equals("Home")) {

            if(command.equals("back")) {
                if(!deque.isEmpty()) {
                    currentLocation = deque.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scan.nextLine();
                    continue;
                }

            } else {
                if (!currentLocation.isEmpty()) {
                    deque.push(currentLocation);
                }
                currentLocation = command;
            }

            System.out.println(currentLocation);
            command = scan.nextLine();
        }

    }
}
