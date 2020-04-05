package task_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        try {
            Child child = new Child(name, age);
            System.out.println(child);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }

}
