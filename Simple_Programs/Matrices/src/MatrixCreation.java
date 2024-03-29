import java.util.Scanner;

public class MatrixCreation {
    // Write a java program to create and display Matrix.

    Scanner scan;
    int[][] matrix;
    int row, column;

    void create() {

        scan = new Scanner(System.in);

        System.out.println("Matrix Creation");

        System.out.println("\nEnter number of rows :");
        row = Integer.parseInt(scan.nextLine());

        System.out.println("Enter number of columns :");
        column = Integer.parseInt(scan.nextLine());

        matrix = new int[row][column];
        System.out.println("Enter the data :");

        for(int i=0; i<row ; i++) {

            for(int j = 0; j < column ; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
    }

    void display() {

        System.out.println("\nThe Matrix is :");

        for(int i = 0; i < row ; i++) {

            for(int j = 0; j < column ; j++) {

                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }
}

class CreateAndDisplayMatrix {

    public static void main(String[] args) {

        MatrixCreation obj = new MatrixCreation();

        obj.create();
        obj.display();
    }
}
