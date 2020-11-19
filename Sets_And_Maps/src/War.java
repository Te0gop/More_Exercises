import java.util.*;
import java.util.stream.Collectors;

public class War {
    /*
    Write a program that:
•	Reads 20 numbers for both players, separated with " " (single space)
•	Every player can hold only unique numbers
Each Round both players get the top number from their own deck. Player with the bigger number get both numbers and add
 it on the bottom of his own sequence
Game ends after 50 rounds or if any player lose all of his numbers
Input
•	Numbers – Integer
Input
•	Output must be "First Player Win!", "Second Player Win!" or "Draw!"
Examples
Input	                                                       Output
26 58 16 92 44 65 65 77 57 23 71 57 7 52 85 44 32 70 38 23
43 95 33 51 62 93 57 55 0 31 32 95 68 34 30 51 37 32 11 97	   Second player win!

74 78 82 42 19 39 29 69 20 42 31 77 57 36 76 26 4 9 83 42
15 43 80 71 22 88 78 35 28 30 46 41 76 51 76 18 14 52 47 38	   First player win!

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {
            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);
            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if(firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (firstNumber < secondNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }
        if(firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }
}
