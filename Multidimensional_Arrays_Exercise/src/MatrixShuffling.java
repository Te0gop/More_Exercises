import java.util.Scanner;

public class MatrixShuffling {
    /*
    Write a program which reads a string matrix from the console and performs certain operations with its elements. User input is provided in a similar way like in the problems above – first you read the dimensions and then the data.
Your program should then receive commands in format: "swap row1 col1 row2c col2" where row1, row2, col1, col2 are coordinates in the matrix. In order for a command to be valid, it should start with the "swap" keyword along with four valid coordinates (no more, no less). You should swap the values at the given coordinates (cell [row1, col1] with cell [row2, col2]) and print the matrix at each step (thus you'll be able to check if the operation was performed correctly).
If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates entered or the given coordinates do not exist), print "Invalid input!" and move on to the next command. Your program should finish when the string "END" is entered.
Examples
Input	            Output
2 3                 5 2 3
1 2 3               4 1 6
4 5 6               Invalid input!
swap 0 0 1 1        5 4 3
swap 10 9 8 7       2 1 6
swap 0 1 1 0
END
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);


        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
                matrix[row] = scanner.nextLine().split("\\s+");
        }


        String line;

        while (!(line = scanner.nextLine()).equals("END")) {

            try {
                String[] indexes = line.split("\\s+");

                if (!indexes[0].equals("swap")) {
                    throw new IllegalArgumentException();
                }

                swapIndexes(matrix, indexes, rows, cols);
                printMatrix(matrix, rows, cols);

            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void swapIndexes(String[][] matrix, String[] indexes, int rows, int cols) {
        String[][] swapMatrix = new String[1][1];

        int firstRow = Integer.parseInt(indexes[1]);
        int firstCol = Integer.parseInt(indexes[2]);
        int secondRow = Integer.parseInt(indexes[3]);
        int secondCol = Integer.parseInt(indexes[4]);

        swapMatrix[0][0] = matrix[firstRow][firstCol];
        matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
        matrix[secondRow][secondCol] = swapMatrix[0][0];

    }

}
