import java.util.Scanner;

public class FillTheMatrix {

    /*
    Write two methods that fill a matrix of size N x N in two different patterns. Both patterns are described below:
    Examples
Input	        Output
3, A            1 4 7
	            2 5 8
                3 6 9

3, B	        1 6 7
                2 5 8
                3 4 9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(", ");

        int dimensions = Integer.parseInt(line[0]);
        char pattern = line[1].charAt(0);

        int[][] matrix = pattern == 'A' ? createMatrixPatternA(dimensions) : createMatrixPatternB(dimensions);
        printMatrix(matrix, pattern);

    }

    private static void printMatrix(int[][] matrix, char pattern) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }


    private static int[][] createMatrixPatternB(int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];

        int counter = 1;
        int index = matrix.length;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                if (col % 2 == 0) {
                    matrix[row][col] = counter++;
                } else {
                    matrix[--index][col] = counter++;
                }
            }
            index = matrix.length;
        }
        return matrix;
    }

    private static int[][] createMatrixPatternA(int dimensions) {

        int[][] matrix = new int [dimensions][dimensions];
        int counter = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter++;
            }

        }
        return matrix;
    }
}
