package task_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPeople = Integer.parseInt(bufferedReader.readLine());


        List<Buyer> list = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] delimiter = bufferedReader.readLine().split("\\s+");
            boolean isRepeating = false;

            for (Buyer buyer : list) {
                if (buyer.getName().equals(delimiter[0])) {
                    isRepeating = true;
                }
            }
            if (!isRepeating) {

                if (delimiter.length == 4) {
                    Buyer citizen = new Citizen(delimiter[0], Integer.parseInt(delimiter[1]),
                            delimiter[2], delimiter[3]);
                    list.add(citizen);
                } else {
                    Buyer rebel = new Rebel(delimiter[0], Integer.parseInt(delimiter[1]),
                            delimiter[2]);
                    list.add(rebel);
                }
            }
        }
        String command = bufferedReader.readLine();

        while (!command.equals("End")) {
            for (Buyer buyer : list) {
                if (buyer.getName().equals(command)) {
                    buyer.buyFood();
                }
            }

            command = bufferedReader.readLine();
        }

                Integer food = list.stream()
                        .mapToInt(x -> x.getFood())
                        .sum();

        System.out.println(food);




    }
}
