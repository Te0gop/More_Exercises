package task_05_comparing_cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstRank = reader.readLine();
        String firstSuite = reader.readLine();
        String secondRank = reader.readLine();
        String secondSuite = reader.readLine();

        try {
            Card firstCard = new Card(firstRank, firstSuite);
            Card secondCard = new Card(secondRank, secondSuite);
            String output = firstCard.compareTo(secondCard) > 0 ? String.valueOf(firstCard) :  String.valueOf(secondCard);
            System.out.println(output);
        } catch (IllegalArgumentException e) {
            ;
        }




    }
}
