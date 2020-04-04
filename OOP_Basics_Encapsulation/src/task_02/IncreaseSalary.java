package task_02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncreaseSalary {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < count ; i++) {

            String[] delimiter = bf.readLine().split(" ");
            String firstName = delimiter[0];
            String lastName = delimiter[1];
            int age = Integer.parseInt(delimiter[2]);
            double salary = Double.parseDouble(delimiter[3]);

            Person person = new Person(firstName, lastName, age, salary);
            people.add(person);
        }
        int bonus = Integer.parseInt(bf.readLine());

        people.forEach(x -> {
            x.increaseSalary(bonus);
            System.out.println(x);
        });

    }
}
