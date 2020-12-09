import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    /*
    You are given an input in the format:
IP=(IP.Address) message=(A&sample&message) user=(username)
Your task is to parse the IP and the username from the input and for every user, you have to display every IP
from which the corresponding user has sent a message and the count of the messages sent with the corresponding IP.
In the output, the usernames must be sorted alphabetically while their IP addresses should be displayed in the
 order of their first appearance. The output should be in the following format:
username:
IP => count, IP => count.
For example, given the following input - IP=192.23.30.40 message='Hello&derps.' user=destroyer, you have to get
 the username destroyer and the IP 192.23.30.40 and display it in the following format:
destroyer:
192.23.30.40 => 1.
The username destroyer has sent a message from IP 192.23.30.40 once.
Check the examples below. They will further clarify the assignment.
Input	                                                                Output
IP=192.23.30.40 message='Hello&derps.' user=destroyer                   destroyer:
IP=192.23.30.41 message='Hello&yall.' user=destroyer                    192.23.30.40 => 2,
IP=192.23.30.40 message='Hello&hi.' user=destroyer                      192.23.30.41 => 1,
IP=192.23.30.42 message='Hello&Dudes.' user=destroyer                   192.23.30.42 => 1.
end

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;

        TreeMap<String, LinkedHashMap<String, Integer>> usersLogs = new TreeMap<>();

        while(!(line = scanner.nextLine()).equals("end")) {
            String[] tokens = line.split("\\s+");
            String ip = tokens[0].split("=")[1]; // we get 1 index of tokens
            String username = tokens[2].split("=")[1];

            if (!usersLogs.containsKey(username)) {
                usersLogs.put(username, new LinkedHashMap<>(){{put(ip, 1);}}); // anonymous instance
            } else if(!usersLogs.get(username).containsKey(ip)) {
                    usersLogs.get(username).put(ip, 1);
            } else {
                if(usersLogs.get(username).containsKey(ip)) {
                    usersLogs.get(username).put(ip, usersLogs.get(username).get(ip) + 1);
                }
            }
        }

        usersLogs.forEach((key, value) -> {
            System.out.println(key + ":");
            StringBuilder sb = new StringBuilder();

            value.forEach((innerKey, innerValue) -> {
                sb.append(String.format("%s => %d, ", innerKey, innerValue));
            });
            System.out.println(sb.substring(0, sb.length() - 2) + ".");
        });

    }
}
