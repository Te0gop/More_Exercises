package task_02_card_rank;
/*
Create an enumeration type that has as its constants the fourteen ranks of a deck of playing cards
(ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING).
Iterate over the values of the enumeration type and print all ordinal values and names.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Rank[] arr = Rank.values();

        String input = reader.readLine();

        if(input.equals("Card Ranks")) {
            System.out.println("Card Ranks:");
            for (Rank rank : arr) {
                System.out.println("Ordinal value: " + rank.ordinal() + "; Name value: " + rank.name());
            }
        }


    }


}
