package task_03_cards_with_power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank = reader.readLine();
        String suite = reader.readLine();

        try {
            Card card = new Card(rank, suite);
            System.out.println(card);
        } catch (IllegalArgumentException e) {
            ;
        }




    }
}
