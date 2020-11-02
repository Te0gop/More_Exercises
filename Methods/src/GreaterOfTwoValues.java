import java.util.Scanner;

public class GreaterOfTwoValues {
    /*
    You are given two values of the same type as input. The values can be of type int, char of String.
    Create a method getMax() that returns the greater of the two values:
Examples
Input	    Output
int
2
16	        16

char
a
z	        z

string
Ivan
Todor	    Todor

     */
    public static int getMax(int firstNum, int secondNum) {
        return Math.max(firstNum, secondNum);
    }
    public static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        }
        return secondChar;
    }
    public static String getMax(String firstStr, String secondStr) {
        if(firstStr.compareTo(secondStr) >= 0) {
            return firstStr;
        }
        return secondStr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String operator = scan.nextLine();

        if(operator.equals("int")) {
            int firstNum = Integer.parseInt(scan.nextLine());
            int secondNum = Integer.parseInt(scan.nextLine());
            System.out.println(getMax(firstNum, secondNum));
        } else if (operator.equals("char")){
            char firstChar = scan.nextLine().charAt(0);
            char secondChar = scan.nextLine().charAt(0);
            System.out.println(getMax(firstChar, secondChar));
        } else {
            String firstStr = scan.nextLine();
            String secondStr = scan.nextLine();
            System.out.println(getMax(firstStr, secondStr));
        }

    }
}
