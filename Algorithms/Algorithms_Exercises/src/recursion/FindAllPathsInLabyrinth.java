package recursion;
//You are given a labyrinth. Your goal is to find all paths from the start (cell 0, 0) to the exit, marked with 'e'.
//•	Empty cells are marked with a dash '-'
//•	Walls are marked with a star '*'
//On the first line, you will receive the dimensions of the labyrinth. Next you will receive the actual labyrinth.
//The order of the paths does not matter.
//Examples
//Input	        Output
//3             RRDD
//3             DDRR
//---
//-*-
//--e


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllPathsInLabyrinth {

    static List<Character> path = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] labyrinth = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            labyrinth[row] = scanner.nextLine().toCharArray();
        }

        findPath(labyrinth, 0, 0, ' ');


    }

    private static void findPath(char[][] labyrinth, int row, int col, char direction) {

        if(!isInBounds(labyrinth, row, col) || labyrinth[row][col] == 'V' || labyrinth[row][col] == '*') {
            return;
        }

        path.add(direction);

        if(labyrinth[row][col] == 'e') {
            printPath();
            path.remove(path.size() - 1);
            return;
        }

        labyrinth[row][col] = 'V';

        findPath(labyrinth, row - 1, col, 'U');
        findPath(labyrinth, row + 1, col, 'D');
        findPath(labyrinth, row, col - 1, 'L');
        findPath(labyrinth, row, col + 1, 'R');

        //Backtracking
        labyrinth[row][col] = '-';

        //Backtrack (remove) last direction
        path.remove(path.size() - 1);
    }

    private static void printPath() {
        for (int i = 1; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row < labyrinth.length && row >= 0 && col < labyrinth[row].length && col >= 0;
    }
}
