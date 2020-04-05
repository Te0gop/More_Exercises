package task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentDelimiter = reader.readLine().split(" ");
        String[] workerDelimiter = reader.readLine().split(" ");

        try {
            Human student = new Student(studentDelimiter[0], studentDelimiter[1], studentDelimiter[2]);
            Human worker = new Worker(workerDelimiter[0], workerDelimiter[1], Double.parseDouble(workerDelimiter[2]),
                    Double.parseDouble(workerDelimiter[3]));
            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }



    }
}
