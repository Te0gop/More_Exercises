import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    /*
    Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).
    Input
•	The first line holds a number n – the size of matrix.
•	The next n lines hold the values for every row – n numbers separated by a space.

Examples
Input	                Output	            Comments
3                       15	                Primary diagonal: sum = 11 + 5 + (-12) = 4
11 2 4                                      Secondary diagonal: sum = 4 + 5 + 10 = 19
4 5 6                                       Difference: |4 - 19| = 15
10 8 -12

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimensions][dimensions];

        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        System.out.println(diagonalDifference(matrix));

    }

    private static int diagonalDifference(int[][] matrix) {

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;


        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonal += matrix[i][i];
        }
        for (int i = 0; i < matrix.length; i++) {
            secondaryDiagonal += matrix[matrix.length - 1 - i][i];
        }

        return Math.abs(primaryDiagonal - secondaryDiagonal);

    }
}
