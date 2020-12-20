import java.util.Scanner;

public class Snake {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dimensions = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[dimensions][dimensions];


        int lairRow = 0;
        int lairCol = 0;

        for (int i = 0; i < dimensions; i++) {

            String line = scanner.nextLine();
            if(line.contains("S")) {
                snakeRow = i;
                snakeCol = line.indexOf("S");
            }
            if(line.contains("B")) {
                lairRow = i;
                lairCol = line.indexOf("B");
            }
            field[i] = line.toCharArray();
        }

         boolean isOutOfBounds = false;

        while (snakesFood < 10 && !isOutOfBounds) {

            String command = scanner.nextLine();

            isOutOfBounds = checkForIndexOutOfBounds(field, snakeRow, snakeCol, command);

            if(!isOutOfBounds) {
               field = move(field, command, snakeRow, snakeCol, lairRow, lairCol, dimensions);
            } else {
                System.out.println("Game over!");
            }

        }
        if(!isOutOfBounds){
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + snakesFood);
        printMatrix(field);

    }

    static int snakesFood = 0;
    static int snakeRow = 0;
    static int snakeCol = 0;

    private static void printMatrix(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] move(char[][] field, String command, int rows, int cols, int lairRows, int lairCols,
                                 int dimensions) {
        char[][] matrix = new char[dimensions][dimensions];

        switch (command) {
            case "left":
                if (field[rows][cols - 1] == 'B') {
                    field[lairRows][lairCols] = field[rows][cols];
                    field[rows][cols - 1] = '.';
                    snakeRow = lairRows;
                    snakeCol = lairCols;
                    field[rows][cols] = '.';
                    break;
                } else if(field[rows][cols - 1] == '*'){
                    field[rows][cols - 1] = field[rows][cols];
                    snakesFood++;
                } else {
                     field[rows][cols - 1] = field[rows][cols];
                }
                snakeRow = rows;
                snakeCol = cols-1;
                field[rows][cols] = '.';
                break;
            case "right":
                if (field[rows][cols + 1] == 'B') {
                    field[lairRows][lairCols] = field[rows][cols];
                    field[rows][cols + 1] = '.';
                    snakeRow = lairRows;
                    snakeCol = lairCols;
                    field[rows][cols] = '.';
                    break;
                } else if(field[rows][cols + 1] == '*'){
                    field[rows][cols + 1] = field[rows][cols];
                    snakesFood++;
                } else {
                    field[rows][cols + 1] = field[rows][cols];
                }
                snakeRow = rows;
                snakeCol = cols+1;
                field[rows][cols] = '.';
                break;
            case "up":
                if (field[rows - 1][cols] == 'B') {
                    field[lairRows][lairCols] = field[rows][cols];
                    field[rows - 1][cols] = '.';
                    snakeRow = lairRows;
                    snakeCol = lairCols;
                    field[rows][cols] = '.';
                    break;
                } else if(field[rows - 1][cols] == '*'){
                    field[rows - 1][cols] = field[rows][cols];
                    snakesFood++;
                } else {
                    field[rows - 1][cols] = field[rows][cols];
                }
                snakeRow = rows-1;
                snakeCol = cols;
                field[rows][cols] = '.';
                break;
            case "down":
                if (field[rows + 1][cols] == 'B') {
                    field[lairRows][lairCols] = field[rows][cols];
                    field[rows + 1][cols] = '.';
                    snakeRow = lairRows;
                    snakeCol = lairCols;
                    field[rows][cols] = '.';
                    break;
                } else if(field[rows + 1][cols] == '*'){
                    field[rows + 1][cols] = field[rows][cols];
                    snakesFood++;
                } else {
                    field[rows + 1][cols] = field[rows][cols];
                }
                snakeRow = rows+1;
                snakeCol = cols;
                field[rows][cols] = '.';
        }
        matrix = field;
        return matrix;
    }

    private static boolean checkForIndexOutOfBounds(char[][] field, int rows, int cols, String command) {
        switch (command) {
            case "left":
                if (cols - 1 < 0) {
                    field[rows][cols] = '.';
                    return true;
                } else {
                    break;
                }
            case "right":
                if (cols + 1 > field.length-1) {
                    field[rows][cols] = '.';
                    return true;
                } else {
                    break;
                }
            case "up":
                if (rows - 1 < 0) {
                    field[rows][cols] = '.';
                    return true;
                } else {
                    break;
                }
            case "down":
                if (rows + 1 > field.length - 1) {
                    field[rows][cols] = '.';
                    return true;
                } else {
                    break;
                }
        }
        return false;
    }

}
