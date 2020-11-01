package exercise;

import java.util.Scanner;
/*
Enter a day number [1…7] and print the day name (in English) or "Invalid day!". Use an array of strings.
Examples:
Input	Output
1	    Monday
2	    Tuesday
7	    Sunday
0	    Invalid day!
 */

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int day = scan.nextInt();

        if (day-1 >= 0 && day-1 < 7) {
            System.out.println(arr[day-1]);
        } else {
            System.out.println("Invalid day!");
        }

    }
}
