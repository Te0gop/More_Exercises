import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    /*
    Write a program that reads an integer N on the first line. And on next N lines read pairs of "[name], [age]".
    Then read three more lines with:
•	Condition - "younger" or "older"
•	Age - Integer
•	Format - "name", "age" or "name age"
Depending on the condition, print the pairs in the right format.
Don’t use any build-in functionality. Write your own methods.
Examples
Input	          Output
5
Pesho, 20         Pesho - 20
Gosho, 18         Mimi - 29
Mimi, 29          Ico - 31
Ico, 31
Simo, 16
older
20
name age

     */
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
        String[] tokens = scanner.nextLine().split(", ");

        people.add(new Person(tokens[0], Integer.parseInt(tokens[1])));

        }

        Map<String, Predicate<Person>> predicateMap = new HashMap<>();

        String ageCondition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        predicateMap.put("younger", person -> person.age < age);
        predicateMap.put("older", person -> person.age >= age);

        Map<String, Consumer<Person>> consumerMap = new HashMap<>();

        consumerMap.put("name", person -> System.out.println(person.name));
        consumerMap.put("age", person -> System.out.println(person.age));
        consumerMap.put("name age", person -> System.out.println(person.name + " - " + person.age));

        String format = scanner.nextLine();

        people
                .stream()
                .filter(predicateMap.get(ageCondition))
                .forEach(consumerMap.get(format));




    }
}

