import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    /*
    Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element. For better code reusability, you could do the comparison in a method, which returns true if they are equal and false if not.
Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in the matrix and C – the number of columns – followed by R lines containing the C numbers, separated by spaces (each line will have an equal amount of numbers.
The matrices will have at most 10 rows and at most 10 columns.
Print equal if the matrices match, and not equal if they don’t match.
Examples
Input	    Output
2 3         equal
1 2 3
2 1 3
2 3
1 2 3
2 1 3

2 3         not equal
1 2 3
4 5 6
2 2
1 3
4 5
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] firstMatrix = readMatrix(scanner, rows, cols, "\\s+");

        dimensions = readArray(scanner);
        rows = dimensions[0];
        cols = dimensions[1];

        int[][] secondMatrix = readMatrix(scanner, rows, cols, "\\s+");

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {

        if(firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = firstMatrix[row];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int col = 0; col < firstArr.length; col++) {
                int firstElement = firstArr[col];
                int secondElement = secondArr[col];
                if (firstElement != secondElement) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] readArray(Scanner scanner) {
            return Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols, String delimiter) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = readArray(scanner);
            matrix[row] = arr;
        }
        return matrix;
    }
}
