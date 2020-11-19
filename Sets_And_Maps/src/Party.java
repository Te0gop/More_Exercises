import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Party {
    /*
    There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular.
When guest comes, you have to check if he/she exist in any of two reservation lists.
All reservation numbers will be with 8 chars.
All VIP numbers start with digit.
There will be 2 command lines. First is "PARTY" - party is on and guests start coming.
Second is "END" - then party is over, and no more guest will come.
Output shows all guests, who didn't come to the party (VIP must be first).
Input	         Output
7IK9Yo0h         2
9NoBUajQ         7IK9Yo0h
Ce8vwPmE         tSzE5t0p
SVQXQCbc
tSzE5t0p
PARTY
9NoBUajQ
Ce8vwPmE
SVQXQCbc
END
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while(!command.equals("PARTY")) {
            if(Character.isDigit(command.charAt(0))) {
                vip.add(command);
            } else {
                regular.add(command);
            }
            command = scan.nextLine();
        }

        String guests = scan.nextLine();

        while(!guests.equals("END")) {
            if(vip.contains(guests)) {
                vip.remove(guests);
            } else {
                regular.remove(guests);
            }
            guests = scan.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        vip.forEach((System.out::println));
        regular.forEach(System.out::println);

    }
}
