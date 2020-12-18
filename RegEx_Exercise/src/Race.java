import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    /*
    Write a program that processes information about a race. On the first line you will be given a list of
    participants separated by ", ". On the next few lines until you receive a line "end of race" you will be given
    some info which will be some alphanumeric characters. In between them you could have some extra characters
    which you should ignore. For example: "G!32e%o7r#32g$235@!2e". The letters are the name of the person and the
    sum of the digits is the distance he ran. So here we have George who ran 29 km. Store the information about
    the person only if the list of racers contains the name of the person. If you receive the same person more
    than once just add the distance to his old distance. At the end print the top 3 racers ordered by distance in
    descending in the format:
"1st place: {first racer}
2nd place: {second racer}
3rd place: {third racer}"

Input	                            Output
George, Peter, Bill, Tom            1st place: George
G4e@55or%6g6!68e!!@                 2nd place: Peter
R1@!3a$y4456@                       3rd place: Tom
B5@i@#123ll
G@e54o$r6ge#
7P%et^#e5346r
T$o553m&6
end of race
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern letters = Pattern.compile("[a-zA-Z]");
        Pattern digits = Pattern.compile("\\d");
        String[] participants = scanner.nextLine().split(", ");
        String line;

        Map<String, Integer> map = new TreeMap<>();

        for (String s : participants) {
            map.put(s, 0);
        }

        while (!(line = scanner.nextLine()).equals("end of race")) {
            Matcher name = letters.matcher(line);
            Matcher numbers = digits.matcher(line);

            StringBuilder participant = new StringBuilder();
            int result = 0;


            while (name.find()) {
                participant.append(name.group());
            }
            while (numbers.find()) {
                result += Integer.parseInt(numbers.group());
            }

            if (map.containsKey(participant.toString())) {
                map.put(participant.toString(), map.get(participant.toString()) + result);
            }

        }

        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();
        list.sort(comparator.reversed());

        System.out.println("1st place: " + list.get(0).getKey());
        System.out.println("2nd place: " + list.get(1).getKey());
        System.out.println("3rd place: " + list.get(2).getKey());

    }
}
