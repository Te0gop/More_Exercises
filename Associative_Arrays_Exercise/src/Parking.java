import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Parking {
    /*
    Write a program, which validates parking for an online service. Users can register to park and unregister to leave.
The program receives 2 commands:
    •	"register {username} {licensePlateNumber}":
    o	The system only supports one car per user at the moment, so if a user tries to register another license plate,
 using the same username, the system should print:
"ERROR: already registered with plate number {licensePlateNumber}"
    o	If the aforementioned checks pass successfully, the plate can be registered, so the
system should print:
 "{username} registered {licensePlateNumber} successfully"
    •	"unregister {username}":
    o	If the user is not present in the database, the system should print:
"ERROR: user {username} not found"
    o	If the aforementioned check passes successfully, the system should print:
"{username} unregistered successfully"
After you execute all of the commands, print all the currently registered users and their license plates in the format:
    •  	"{username} => {licensePlateNumber}"
Input
    •	First line: n - number of commands - integer
    •	Next n lines: commands in one of two possible formats:
    o	Register: "register {username} {licensePlateNumber}"
    o	Unregister: "unregister {username}"
The input will always be valid and you do not need to check it explicitly.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        Map<String, String> map = new LinkedHashMap<>();

        for (int i = 0; i < number ; i++) {
            String[] line = scan.nextLine().split(" ");

            String command = line[0];
            String name = line[1];

            if(command.equals("register")) {
                String license = line[2];
                if(!map.containsKey(name)) {
                    map.put(name, license);
                    System.out.printf("%s registered %s successfully%n", name, license);
                } else {
                    System.out.println("ERROR: already registered with plate number " + license);
                }

            } else if (command.equals("unregister")) {
                if(map.containsKey(name)) {
                    map.remove(name, map.get(name));
                    System.out.println(name + " unregistered successfully");
                } else {
                    System.out.printf("ERROR: user %s not found%n", name);
                }
            }

        }
        map
                .entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
    }
}
