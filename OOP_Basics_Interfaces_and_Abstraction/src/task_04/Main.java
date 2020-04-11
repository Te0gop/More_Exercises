package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Smartphone phone = new Smartphone();

        String[] phoneNumbers = bufferedReader.readLine().split("\\s+");
        String[] url = bufferedReader.readLine().split("\\s+");

        Arrays.stream(phoneNumbers).forEach(x -> {
            try {
            System.out.println(phone.calling(x));
        } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        });
        Arrays.stream(url).forEach(x -> {
            try {
                System.out.println(phone.browsing(x));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        });

    }
    
}
