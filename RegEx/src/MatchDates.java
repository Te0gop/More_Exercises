import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    /*
    Write a program, which matches a date in the format “dd{separator}MMM{separator}yyyy”.
    Use named capturing groups in your regular expression.
Compose the Regular Expression
Every valid date has the following characteristics:
•	Always starts with two digits, followed by a separator
•	After that, it has one uppercase and two lowercase letters (e.g. Jan, Mar).
•	After that, it has a separator and exactly 4 digits (for the year).
•	The separator could be either of three things: a period (“.”), a hyphen (“-“) or a forward slash (“/”)
•	The separator needs to be the same for the whole date (e.g. 13.03.2016 is valid, 13.03/2016 is NOT). Use a group backreference to check for this.
You can follow the table below to help with composing your RegEx:
Match ALL of these	                                Match NONE of these
13/Jul/1928, 10-Nov-1934, 25.Dec.1937	            01/Jan-1951, 23/sept/1973, 1/Feb/2016

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dates = scanner.nextLine();
        Pattern pattern =
                Pattern.compile("\\b(?<day>([0-9][0-9]))([-.\\/])(?<month>([A-Z][a-z]{2,3}))(\\3)(?<year>(\\d){4})\\b");
        Matcher matcher = pattern.matcher(dates);

        while (matcher.find()) {

            System.out.println("Day: " + matcher.group("day") + ", " +
                    "Month: " + matcher.group("month") + ", " +
                    "Year: " + matcher.group("year"));
        }
    }
}
