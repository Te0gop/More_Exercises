import java.util.*;

public class Courses {
    /*
    Write a program, which keeps information about courses. Each course has a name and registered students.
You will receive course name and student name, until you receive the command "end". Check if such course already exists,
 and if not - add the course. Register the user into the course. When you do receive the command "end",
 print the courses with their names and total registered users, ordered by the count of registered
 users in descending order. For each contest print registered users ordered by name in ascending order.
Input
    •	Until you receive "end", the input come in the format: "{courseName} : {studentName}"
    • 	The product data is always delimited by " : "
Output
    •	Print information about each course, following the format:
    "{courseName}: {registeredStudents}"
    •	Print information about each student, following the format:
    "-- {studentName}"
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        Map<String, List<String>> courses = new LinkedHashMap<>();

        while(!line.equals("end")) {
            String[] delimiter = line.split(" : ");
            String courseName = delimiter[0];
            String student = delimiter[1];

            if(!courses.containsKey(courseName)) {
                courses.put(courseName, new LinkedList<>());
                courses.get(courseName).add(student);
            } else {
                courses.get(courseName).add(student);
            }

            line = scan.nextLine();
        }
        courses
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(entry -> {
                    System.out.printf("%s: %d%n",entry.getKey(), entry.getValue().size());
                    entry
                            .getValue()
                            .stream()
                            .sorted((a, b) -> a.compareTo(b))
                            .forEach(s -> System.out.println("-- " + s));
                });

    }
}
