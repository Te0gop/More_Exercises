package task_04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Team team = new Team("Slavia");

        int count = Integer.parseInt(bf.readLine());

        for (int i = 0; i < count ; i++) {

            try {
                String[] delimiter = bf.readLine().split(" ");
                String firstName = delimiter[0];
                String lastName = delimiter[1];
                int age = Integer.parseInt(delimiter[2]);
                double salary = Double.parseDouble(delimiter[3]);

                Person person = new Person(firstName, lastName, age, salary);
                team.addPlayer(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(team);


    }
}
