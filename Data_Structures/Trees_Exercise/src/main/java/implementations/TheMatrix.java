package implementations;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char startChar;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.startChar = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
        fillMatrix(startRow, startCol);
    }

    private void fillMatrix(int row, int col) {

        if(isOutOfBounds(row, col) || matrix[row][col] != startChar) {
            return;
        }

        matrix[row][col] = fillChar;
        System.out.println(toOutputString());
        System.out.println();

        fillMatrix(row + 1, col);
        fillMatrix(row, col + 1);
        fillMatrix(row - 1, col);
        fillMatrix(row, col - 1);
    }

    private boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    public String toOutputString() {
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                builder.append(matrix[r][c]);
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
