import java.util.*;
import java.util.stream.Collectors;

public class StudentAcademy {
    /*
Write a program, which keeps information about students and their grades.
On the first line you will receive number n. After that you will receive n pair of rows.
First you will receive the student's name, after that you will receive his grade. Check if student already exists,
and if not - add him. Keep track of all grades for each student.
When you finish reading data, keep students with average grade higher or equal to 4.50.
Order filtered students by average grade in descending order.
Print the students and their average grade in format:
    "{name} –> {averageGrade}"
    Format the average grade to the 2nd decimal place.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numOfStudents = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> map = new LinkedHashMap<>();

        for (int i = 0; i < numOfStudents; i++) {
            String student = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            if (!map.containsKey(student)) {
                map.put(student, new ArrayList<>());
            }
            map.get(student).add(grade);

        }

        Map<String, Double> averageGrade = new LinkedHashMap<>();

        for(Map.Entry<String, List<Double>> entry : map.entrySet()) {
            double average = entry
                    .getValue()
                    .stream()
                    .mapToDouble(x -> x)
                    .average()
                    .getAsDouble();
            if (average >= 4.50) {
                averageGrade.put(entry.getKey(), average);
            }
        }

        averageGrade
                .entrySet()
                .stream()
                .sorted((a , b) -> b.getValue().compareTo(a.getValue()))
                .forEach(grade -> System.out.printf("%s -> %.2f%n", grade.getKey(), grade.getValue()));

    }
}
