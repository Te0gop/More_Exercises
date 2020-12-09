import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = readArray(scanner, ", ");
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = readMatrix(scanner, rows, cols, ", ");

        int sum = 0;

        for (int[] arr : matrix) {
            for (int num : arr) {
                sum += num;
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
    private static int[] readArray(Scanner scanner, String delimiter) {
        return Arrays.stream(scanner.nextLine()
                .split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols, String delimiter) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = readArray(scanner, delimiter);
            matrix[row] = arr;
        }
        return matrix;
    }
}
