import java.util.*;

public class AcademyGraduation {
    /*
    Write a program that:
•	Reads from console number of students for a track
•	Reads on pair of rows:
o	First line is the name of student
o	Second line is his score for different number of courses
•	Print on console “{name} is graduated with {average scores)”
Input	            Output
3                   Gosho is graduated with 4.375
Gosho               Mara is graduated with 5.125
3.75 5              Pesho is graduated with 5.25
Mara
4.25 6
Pesho
6 4.5
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int loopsRep = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> map = new TreeMap<>();

        for (int i = 0; i <loopsRep; i++) {

            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split(" ");

                map.put(name, new ArrayList<>());

            for (String grade : grades) {
                map.get(name).add(Double.parseDouble(grade));
            }
        }

        map.forEach((key, value) -> {
                value.stream()
                        .mapToDouble(e -> e)
                        .average()
                        .stream().boxed()
                        .forEach(avgSum -> {
                            System.out.println(key + " is graduated with " + avgSum);
                        });
        });

/*
            OptionalDouble avg = value.stream().mapToDouble(grade -> grade).average();
                System.out.println(key + " is graduated with " + avg.getAsDouble());
 */
    }

}
