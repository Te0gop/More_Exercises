import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    /*
    Write a program that reads a rectangular integer matrix of size N x M and finds in it the square 3 x 3 that has maximal sum of its elements.
Input
•	On the first line, you will receive the rows N and columns M.
•	On the next N lines you will receive each row with its elements.
Print the elements of the 3 x 3 square as a matrix, along with their sum. See the format of the output below:
Examples
Input	                        Output
4 5                             Sum = 75
1 5 5 2 4                       1 4 14
2 1 4 14 3                      7 11 2
3 7 11 2 8                      8 12 16
4 8 12 16 4
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndColumns = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndColumns[0];
        int cols = rowsAndColumns[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int row = 0, col = 0;

        for (int r = 1; r < matrix.length - 1; r++) {
            for (int c = 1; c < matrix[r].length - 1; c++) {
                int sum = getSum(matrix, r, c);
                if (sum > maxSum) {
                    maxSum = sum;
                    row = r;
                    col = c;
                }
            }

        }

        System.out.println("Sum = " + maxSum);

        row--;
        col--;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] matrix, int r, int c) {
        int sum = 0;
        r--;
        c--;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}

