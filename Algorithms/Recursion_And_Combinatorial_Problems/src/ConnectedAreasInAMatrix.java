import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedAreasInAMatrix {
    //Let’s define a connected area in a matrix as an area of cells in which there is a path between every two cells.
    //Write a program to find all connected areas in a matrix.
    //On the console, print the total number of areas found, and on a separate line some info about each of the areas –
    // its position (top-left corner) and size.
    //Order the areas by size (in descending order) so that the largest area is printed first. If several areas have
    // the same size, order them by their position, first by the row, then by the column of the top-left corner. So,
    // if there are two connected areas with the same size, the one which is above and/or to the left of the other will be printed first.
    //On the first line, you will get the number of rows.
    //On the second line, you will get the number of columns.
    //The rest of the input will be the actual matrix.
    //Example Layout	        Output
    //4                         Total areas found: 3
    //9                         Area #1 at (0, 0), size: 13
    //---*---*-                 Area #2 at (0, 4), size: 10
    //---*---*-                 Area #3 at (0, 8), size: 5
    //---*---*-
    //----*-*--

    public static char[][] matrix;
    public static List<int[]> areas;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        matrix = new char[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        areas = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == '-') {
                    areas.add(new int[] {row, col, 0});
                    findAreas(row, col);
                }
            }

        }
        System.out.println("Total areas found: " + areas.size());

        AtomicInteger counter = new AtomicInteger(1);
        areas.stream()
                .sorted((f,s) -> Integer.compare(s[2], f[2]))
                .forEach(a -> {
                    System.out.println("Area #"+ counter.getAndIncrement()
                            + " at (" + a[0] + ", " + a[1] + "), size: " + a[2]);
                });

    }

    private static void findAreas(int row, int col) {
        if(isOutOfBounds(row,col) || isNotTraversable(row, col)) {
            return;
        }
        matrix[row][col] = 'V';

        areas.get(areas.size() - 1)[2]++;

        findAreas(row + 1, col);
        findAreas(row, col + 1);
        findAreas(row - 1, col);
        findAreas(row, col - 1);
    }

    private static boolean isNotTraversable(int row, int col) {
        return matrix[row][col] == 'V' || matrix[row][col] == '*';
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
