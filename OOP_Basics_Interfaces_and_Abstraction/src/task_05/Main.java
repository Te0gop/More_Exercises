package task_05;

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
            if(delimiter.length == 2) {
                Identifiable robot = new Robot(delimiter[0], delimiter[1]);
                list.add(robot);
            } else {
                Identifiable citizen = new Citizen(delimiter[0], Integer.parseInt(delimiter[1]),
                        delimiter[2]);
                list.add(citizen);
            }

            delimiter = bufferedReader.readLine().split("\\s+");
        }
        String fakeId = bufferedReader.readLine();

        list
                .stream()
                .filter(x -> x.getId().endsWith(fakeId))
                .forEach(x -> System.out.println(x.getId()));
    }
}
