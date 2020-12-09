import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    /*
    Write a program that receives some info from the console about people and their phone numbers.
You are free to choose the manner in which the data is entered; each entry should have just one name and one number
(both of them strings). If you receive a name that already exists in the phonebook, simply update its number.
After filling this simple phonebook, upon receiving the command "search", your program should be able to perform
a search of a contact by name and print her details in format "{name} -> {number}". In case the contact isn't
found, print "Contact {name} does not exist."
Examples:
Input	Output
George-0888080808              Contact Maria does not exist.
search                         George -> 0888080808
Maria
George
stop
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String[] contacts = scanner.nextLine().split("-");

        while (!contacts[0].equals("stop")) {

            if(contacts[0].equals("search")) {

                while(contacts.length == 1 && !contacts[0].equals("stop")) {
                    String nameToCheck = scanner.nextLine();

                    if(nameToCheck.equals("stop")) {
                        return;
                    }

                    if (phonebook.containsKey(nameToCheck)) {
                        System.out.println(nameToCheck + " -> " + phonebook.get(nameToCheck));
                    } else {
                        System.out.println("Contact " + nameToCheck + " does not exist.");
                    }
                }
            }
            phonebook.put(contacts[0], contacts[1]);
            contacts = scanner.nextLine().split("-");
        }


    }
}
