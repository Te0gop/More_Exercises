package task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ValidationData {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < count ; i++) {

            try {
                String[] delimiter = bf.readLine().split(" ");
                String firstName = delimiter[0];
                String lastName = delimiter[1];
                int age = Integer.parseInt(delimiter[2]);
                double salary = Double.parseDouble(delimiter[3]);

                Person person = new Person(firstName, lastName, age, salary);
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        double bonus = Double.parseDouble(bf.readLine());

        people.forEach(person -> {
            person.increaseSalary(bonus);
            System.out.println(person);
        });

    }
}
