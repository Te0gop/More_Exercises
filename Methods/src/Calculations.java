import java.util.Scanner;

public class Calculations {
    /*
    Write a program that receives a string on the first line ("add", "multiply", "subtract", "divide") and on the next
    two lines receives two numbers. Create four methods (for each calculation) and invoke the right one depending on
    the command. The method should also print the result (needs to be void).
Example
Input	   Output
subtract
5
4	        1

divide
8
4	        2
     */
    public static void calculate(String operation, int firstNumber, int secondNumber) {
        switch (operation) {
            case "divide":
                System.out.println(firstNumber / secondNumber);
                break;
            case "subtract":
                System.out.println(firstNumber - secondNumber);
                break;
            case "add":
                System.out.println(firstNumber + secondNumber);
                break;
            case "multiply":
                System.out.println(firstNumber * secondNumber);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String operation = scan.nextLine();
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());

        calculate(operation, firstNumber, secondNumber);
    }

}
