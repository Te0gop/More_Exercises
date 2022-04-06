import java.util.Scanner;

public class AddTwoMatrices {
    // Write a java program to Add two Matrices

    int m, n;
    int[][] first = new int[m][n];
    int[][] second = new int[m][n];

    AddTwoMatrices(int[][] first, int[][] second, int m, int n) {
        this.first = first;
        this.second = second;
        this.m = m;
        this.n = n;
    }

    public static void main(String[] args) {
        int m, n, c, d;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of matrix");
        m = in.nextInt();
        n = in.nextInt();

        int[][] first = new int[m][n];
        int[][] second = new int[m][n];

        System.out.println("Enter the elements of first matrix");

        for (c = 0; c < m; c++) {
            for (d = 0; d < n; d++) {
                first[c][d] = in.nextInt();
            }
        }

        System.out.println("Enter the elements of second matrix");

        for (c = 0; c < m; c++) {
            for (d = 0; d < n; d++) {
                second[c][d] = in.nextInt();
            }
        }

        System.out.println("\nElements of First matrix is : ");

        for (c = 0; c < m; c++) {
            for (d = 0; d < n; d++) {
                System.out.print(first[c][d] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nElements of Second matrix is : ");

        for (c = 0; c < m; c++) {
            for (d = 0; d < n; d++) {
                System.out.print(second[c][d] + "\t");
            }
            System.out.println();
        }

        AddTwoMatrices a = new AddTwoMatrices(first, second, m, n);
        // call by reference
        a.addMatrix(a); // Passing Object
    }

    // Function for Adding two matrix and storing in third matrix
    public void addMatrix(AddTwoMatrices a) {
        int c, d;
        int[][] sum = new int[a.m][a.n];

        for (c = 0; c < a.m; c++) {
            for (d = 0; d < a.n; d++) {
                sum[c][d] = a.first[c][d] + a.second[c][d];
            }
        }

        System.out.println("\nSum of the two matrices is : ");

        for (c = 0; c < a.m; c++) {
            for (d = 0; d < a.n; d++) {
                System.out.print(sum[c][d] + "\t");
            }
            System.out.println();
        }
    }
}
