import java.util.*;
import java.util.stream.Collectors;

public class CitiesByContinentsAndCountry {
    /*
    Write a program to read continents, countries and their cities, put them in a nested map and print them
    in the order of first appearance.
Input	                                    Output
9
Europe Bulgaria Sofia                       Europe:
Asia China Beijing                            Bulgaria -> Sofia, Plovdiv
Asia Japan Tokyo                              Poland -> Warsaw, Poznan
Europe Poland Warsaw                          Germany -> Berlin
Europe Germany Berlin                       Asia:
Europe Poland Poznan                          China -> Beijing, Shanghai
Europe Bulgaria Plovdiv                       Japan -> Tokyo
Africa Nigeria Abuja                        Africa:
Asia China Shanghai                           Nigeria -> Abuja
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int loopRepeat = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, LinkedList<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < loopRepeat; i++) {
            String[] delimiter = scanner.nextLine().split("\\s+");
            String continent = delimiter[0];
            String country = delimiter[1];
            String city = delimiter[2];

            if (map.containsKey(continent)) {
                if (!map.get(continent).containsKey(country)) {
                    map.get(continent).put(country, new LinkedList<>());
                }

            } else {
                map.put(continent, new LinkedHashMap<>());
                map.get(continent).put(country, new LinkedList<>());

            }
            map.get(continent).get(country).add(city);
        }


            map.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((innerKey, innerValue) -> {
                System.out.print("  " + innerKey + " -> ");
                System.out.println(String.join(", ", innerValue));
            });
        });

    }
}
