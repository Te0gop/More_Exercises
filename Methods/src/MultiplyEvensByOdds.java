import java.util.Scanner;

public class MultiplyEvensByOdds {
    /*
    Create a program that reads an integer number and multiplies the sum of all its even digits by
    the sum of all its odd digits:
Examples
Input	   Output	      Comments
12345	   54	          12345 has 2 even digits - 2 and 4. Even digits have sum of 6.
                          Also it has 3 odd digits - 1, 3 and 5. Odd digits have sum of 9.
                          Multiply 6 by 9 and you get 54.
-12345	   54
     */

    public static int multiplyOddAndEven(int[] numbers) {
        int even = 0;
        int odd = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                even += numbers[i];
            } else {
                odd += numbers[i];
            }
        }
        return Math.abs(even * odd);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = scan.nextLine() //прочита ред от конзолата, напр.: "-12345"
                .chars() //преобразува го до int поток (stream) от ASCII кода на всеки символ: 45, 49, 50, 51, 52, 53
                .filter(Character::isDigit) //пропуска само кодовете, които отговарят на цифри: 49, 50, 51, 52, 53
                .map(Character::getNumericValue) //преобразува кодовете до тяхната цифрова стойност (int) : 1, 2, 3, 4, 5
                .toArray(); //създава int[] с всички цифри: [ 1, 2, 3, 4, 5 ]

        System.out.println(multiplyOddAndEven(numbers));
    }
}
