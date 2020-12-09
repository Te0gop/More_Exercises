import java.util.*;

public class HandsOfCards {

    /*
    You are given a sequence of people and for every person what cards he draws from the deck.
    The input will be separate lines in the format:
{personName}: {PT, PT, PT,… PT}
Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type.
The input ends when a "JOKER" is drawn. The name can contain any ASCII symbol except ':'. The input will always
be valid and in the format described, there is no need to check it.
A single person cannot have more than one card with the same power and type, if he draws such a card he
discards it. The people are playing with multiple decks. Each card has a value that is calculated by the
power multiplied by the type. Powers 2 to 10 have the same value and J to A are 11 to 14. Types are mapped to
multipliers the following way (S -> 4, H-> 3, D -> 2, C -> 1).
Finally print out the total value each player has in his hand in the format:
{personName}: {value}
Input	                             Output
Pesho: 2C, 4H, 9H, AS, QS            Pesho: 167
Slav: 3H, 10S, JC, KD, 5S, 10S       Slav: 175
Peshoslav: QH, QC, QS, QD            Peshoslav: 197
Slav: 6H, 7S, KC, KD, 5S, 10C
Peshoslav: QH, QC, JS, JD, JC
Pesho: JD, JD, JD, JD, JD, JD
JOKER
     */
    public static void main(String[] args) {

        Map<String, LinkedHashSet<String>> players = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        String line;

        while(!(line = scanner.nextLine()).equals("JOKER")) {
            String[] tokens = line.split(": ");
            String name = tokens[0];
            String[] hand = tokens[1].split(", ");

            if(!players.containsKey(name)) {
                players.put(name, new LinkedHashSet<>(Arrays.asList(hand)));
            } else {
                players.get(name).addAll(Arrays.asList(hand));
            }
        }

        players.forEach((key, value) -> {
            int totalPower = 0;
            for (String s : value) {
                totalPower += getPower(s) * getMultiplier(s);
            }
            System.out.printf("%s: %d%n", key, totalPower);
        });

    }
    private static int getPower(String power) {
        String[] card = power.split("");

        if(card.length == 3) { // because of 10. it's [1, 0, S] array (length it's 3 when we have 10).
            return 10;
        }

        switch (card[0]) {
            case "A":
                return 14;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            default:
                return Integer.parseInt(card[0]);
        }
    }
    private static int getMultiplier(String power) {
        String[] card = power.split("");
        String multiplier;

        if (card.length == 3) { // because of 10. it's [1, 0, S] array (length it's 3 when we have 10).
            multiplier = card[2];
        } else {
            multiplier = card[1];
        }

        switch (multiplier) {
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;
            default:
                return 0;
        }
    }
}
