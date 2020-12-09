import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    /*
    Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints third matrix C[][] which is filled with the intersecting elements of A and B, otherwise set the element to '*'. On the first two lines you receive M and N, then on 2 * M lines N characters – the matrices elements.
The matrix elements may be any ASCII char except '*'.
Examples
Input	        Output
3               * b c *
4               a b * d
a b c d         a * c d
a b c d
a b c d
k b c k
a b g d
a k c d

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] first = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                first[row][col] = line[col].charAt(0);
            }
        }

        char[][] second = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                second[row][col] = line[col].charAt(0);
            }
        }

        char[][] resultMatrix = new char[rows][cols];

        for (int row = 0; row < first.length; row++) {
            char[] firstArr = first[row];
            char[] secondArr = second[row];

            for (int col = 0; col < firstArr.length; col++) {
                char symbol = firstArr[col] == secondArr[col] ? firstArr[col] : '*';
                resultMatrix[row][col] = symbol;
            }
        }

        for (int row = 0; row < resultMatrix.length; row++) {
            for (int col = 0; col < resultMatrix[row].length; col++) {
                System.out.print(resultMatrix[row][col] + " ");

            }
            System.out.println();
        }




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
