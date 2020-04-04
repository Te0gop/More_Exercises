package task_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByNameAndAge {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < count ; i++) {

            String[] delimiter = bf.readLine().split(" ");
            String firstName = delimiter[0];
            String lastName = delimiter[1];
            int age = Integer.parseInt(delimiter[2]);

            Person person = new Person(firstName, lastName, age);
            people.add(person);
        }

        Collections.sort(people, (firstPerson, secondPerson) -> {
        int compare = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if(compare != 0) {
                return compare;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        for (Person persons : people) {
            System.out.println(persons);

        }
    }

}
