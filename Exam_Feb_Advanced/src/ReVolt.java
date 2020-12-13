import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());


        String[][] matrix = new String[dimensions][dimensions];

        boolean isWon = false;

        for (int row = 0; row < dimensions; row++) {
                matrix[row] = scanner.nextLine().split("");
        }

        for (int i = 0; i < commandsCount; i++) {

            String command = scanner.nextLine();

            isWon = run(matrix, dimensions,command);

            if (isWon) {
                break;
            }
        }


        if (isWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix, dimensions);
    }

    private static boolean hasWon = false;

    private static void printMatrix(String[][] matrix, int dimensions) {
        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void checkForBonusOrTrap(String[][] matrix, int row, int col, String command) {

                    switch (command) {
                        case "up":
                            if (matrix[row - 1][col].equals("B")) {
                                if (row - 2 < 0) {
                                    findF(matrix[matrix.length-1][col]);
                                    matrix[matrix.length-1][col] = matrix[row][col];
                                } else {
                                    matrix[row - 2][col] = matrix[row][col];
                                }

                                matrix[row][col] = "-";
                                return;
                            } else if (matrix[row - 1][col].equals("T")) {
                                return;
                            } else if (matrix[row - 1][col].equals("F")) {
                                hasWon = true;
                                move(matrix, row, col, command);
                                return;
                            }
                            break;
                        case "down":
                            if (matrix[row + 1][col].equals("B")) {
                                if (row + 2 > matrix.length-1) {
                                    findF(matrix[0][col]);
                                    matrix[0][col] = matrix[row][col];

                                } else {
                                    matrix[row + 2][col] = matrix[row][col];
                                }
                                matrix[row][col] = "-";
                                return;

                            } else if (matrix[row + 1][col].equals("T")) {
                                return;
                            } else if (matrix[row + 1][col].equals("F")) {
                                hasWon = true;
                                move(matrix, row, col, command);
                                return;
                            }
                            break;
                        case "left":
                            if (matrix[row][col - 1].equals("B")) {
                                if(col-2 < 0) {
                                    findF(matrix[row][matrix.length-1]);
                                    matrix[row][matrix.length-1] = matrix[row][col];
                                } else {
                                    matrix[row][col-2] = matrix[row][col];
                                }
                                matrix[row][col] = "-";
                                return;
                            } else if (matrix[row][col - 1].equals("T")) {
                                return;
                            } else if (matrix[row][col - 1].equals("F")) {
                                hasWon = true;
                                move(matrix, row, col, command);
                                return;
                            }
                            break;
                        case "right":
                            if (matrix[row][col + 1].equals("B")) {
                                if(col - 2 < 0) {
                                    findF(matrix[row][col + 1]);
                                    matrix[row][0] = matrix[row][col];
                                } else {
                                    matrix[row][col + 2] = matrix[row][col];
                                }
                                matrix[row][col] = "-";
                                return;
                            } else if (matrix[row][col + 1].equals("T")) {
                                return;
                            } else if (matrix[row][col + 1].equals("F")) {
                                hasWon = true;
                                move(matrix, row, col, command);
                                return;
                            }
                            break;
                    }

        move(matrix, row, col, command);
    }

    public static void findF(String letter) {
        if (letter.equals("F")) {
            hasWon = true;
        }
    }

    public static void checkForIndexOutOfBounds(String[][] matrix, int row, int col, String command) {

                if (row - 1 < 0 && command.equals("up")) {
                    findF(matrix[matrix.length-1][col]);
                    matrix[matrix.length-1][col] = matrix[row][col];
                    matrix[row][col] = "-";
                    return;
                } else if (row + 1 > matrix.length-1 && command.equals("down")) {
                    findF(matrix[0][col]);
                    matrix[0][col] = matrix[row][col];
                    matrix[row][col] = "-";
                    return;
                } else if (col - 1 < 0 && command.equals("left")) {
                    findF(matrix[row][matrix.length-1]);
                    matrix[row][matrix.length-1] = matrix[row][col];
                    matrix[row][col] = "-";
                    return;
                } else if (col + 1 > matrix.length-1 && command.equals("right")) {
                    findF(matrix[row][0]);
                    matrix[row][0] = matrix[row][col];
                    matrix[row][col] = "-";
                    return;
                }

                checkForBonusOrTrap(matrix, row, col, command);

    }

    private static void move(String[][] matrix, int row, int col, String command) {

                switch (command) {
                    case "up":
                        matrix[row-1][col] = matrix[row][col];
                        matrix[row][col] = "-";
                        break;
                    case "down":
                        matrix[row + 1][col] = matrix[row][col];
                        matrix[row][col] = "-";
                        break;
                    case "left":
                        matrix[row][col - 1] = matrix[row][col];
                        matrix[row][col] = "-";
                        break;
                    case "right":
                        matrix[row][col + 1] = matrix[row][col];
                        matrix[row][col] = "-";
                        break;
                }
    }

    private static boolean run(String[][] matrix, int dimensions, String command) {

        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                if(matrix[row][col].equals("f")) {
                    checkForIndexOutOfBounds(matrix, row, col, command);
                    return hasWon;
                }
            }
        }
        return false;
    }
}
