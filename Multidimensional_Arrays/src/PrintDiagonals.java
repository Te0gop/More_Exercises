import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    /*
    Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square.
     On the first line you read a single integer N the matrix size. Then on each line N elements.
     The first diagonal should always start with the element at the first row and col, the second diagonal
     should start with the element at the last row and first col.
Examples

Input	        Output
3               1 2 3
1 2 3           1 2 3
1 2 3
1 2 3

4               1 1 1 1
1 2 3 2         2 2 2 2
1 1 2 4
1 2 1 4
2 2 3 1

     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int row = 0;
        int col = 0;

        for (int i = 0; i < size; i++) {
            System.out.print(matrix[row++][col++] + " ");
        }

        row = size - 1;
        col = 0;

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[row--][col++] + " ");
        }
    }
}
