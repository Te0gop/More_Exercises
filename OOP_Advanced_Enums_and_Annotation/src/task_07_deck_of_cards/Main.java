package task_07_deck_of_cards;
/*
Create a program that generates all cards of a card playing deck. First print the clubs, starting from the ace,
ending with a king. Continue with the same cards from diamonds, hearts and spades. Print them in the format below.
Note
Try using the enumeration types you have created in the previous problems.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

        Rank[] ranks = Rank.values();
        Suite[] suites = Suite.values();

        if(command.equals("Card Deck")) {
            for (int i = 0; i < suites.length; i++) {
                for (int j = 0; j < ranks.length; j++) {
                    System.out.println(ranks[j] + " of " + suites[i]);
                }
            }
        }
    }
}
