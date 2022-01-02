import java.util.*;

public class MoveDownRight {
    //Given a matrix of N by M cells filled with positive integers, find the path from top left to bottom right
    // with a highest sum of cells by moving only down or right.
    //Examples
    //Input	                Output
    //4                     [0, 0] [1, 0] [1, 1] [2, 1] [3, 1] [3, 2] [3, 3]
    //4
    //1 3 2 1
    //5 3 2 1
    //1 7 3 1
    //1 3 1 1

    //3                     [0, 0] [1, 0] [2, 0] [2, 1] [2, 2]
    //3
    //1 1 1
    //1 1 1
    //1 1 1

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] elements = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            elements[row] = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] table = new int[rows][cols];

        table[0][0] = elements[0][0];

        for (int col = 1; col < cols; col++) {
            table[0][col] = table[0][col - 1] + elements[0][col];
        }
        for (int row = 1; row < rows; row++) {
            table[row][0] = table[row - 1][0] + elements[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                table[row][col] = Math.max(table[row - 1][col] + elements[row][col],
                        table[row][col - 1] + elements[row][col]);
            }
        }

        // end
        int row = rows - 1;
        int col = cols - 1;

        List<String> path = new ArrayList<>();

        path.add(formatOutput(row,col));

        while (row > 0 || col > 0) {
            int top = -1;
            int left = -1;

            if(row > 0) {
                top = table[row - 1][col];
            }

            if(col > 0) {
                left = table[row][col - 1];
            }

            if(top > left) {
                row--;
            } else {
                col--;
            }
            path.add(formatOutput(row, col));
        }

        Collections.reverse(path);
        System.out.println(String.join(" ", path));
    }

    private static String formatOutput(int row, int col) {
        return "[" + row + ", " + col + "]";
    }
}
