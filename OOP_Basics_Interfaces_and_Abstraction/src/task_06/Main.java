package task_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] delimiter = bufferedReader.readLine().split("\\s+");

        List<Identifiable> list = new ArrayList<>();

        while(!delimiter[0].equals("End")) {
            if (delimiter[0].equals("Robot")) {
                Identifiable robot = new Robot(delimiter[1], delimiter[2]);
                list.add(robot);
            } else if (delimiter[0].equals("Pet")) {
                Identifiable pet = new Pet(delimiter[1], delimiter[2]);
                list.add(pet);
            } else {
                    Identifiable citizen = new Citizen(delimiter[1], Integer.parseInt(delimiter[2]),
                        delimiter[3], delimiter[4]);
                list.add(citizen);
            }

            delimiter = bufferedReader.readLine().split("\\s+");
        }
        String birthYear = bufferedReader.readLine();

        list
                .stream()

                .filter(x -> {
                    if(!x.getClass().getSimpleName().equals("Robot")) {
                        return x.getBirthDate().endsWith(birthYear);
                    }
                    return false;
                })
                .forEach(x -> System.out.println(x.getBirthDate()));
    }
}
