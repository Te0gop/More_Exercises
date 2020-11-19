import java.util.*;

public class AverageStudentsGrades {
    /*
    Write a program, which reads the name of a student and their grades and adds them to the student record, then prints grades along with their average grade – ordered the output by the names of the students.
Input
On the first line N – the number of students, then on the next N lines student name with grade.
Examples
Input	                     Output
7
Ivancho 5.20
Mariika 5.50
Ivancho 3.20
Mariika 2.50
Stamat 2.00
Mariika 3.46
Stamat 3.00	                  Ivancho -> 5.20 3.20 (avg: 4.20)
                              Mariika -> 5.50 2.50 3.46 (avg: 3.82)
                              Stamat -> 2.00 3.00 (avg: 2.50)

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number; i++) {
            String[] parameters = scan.nextLine().split("\\s+");
            String studentName = parameters[0];
            double studentGrade = Double.parseDouble(parameters[1]);
            
            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(studentGrade);
        }

        students.entrySet()
                .stream()
                .forEach(entry -> {
                    double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);
                    }
                    double avgSum = sum / entry.getValue().size();

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n", avgSum);
                });
    }
}
