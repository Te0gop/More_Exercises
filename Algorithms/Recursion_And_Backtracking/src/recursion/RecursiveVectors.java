package recursion;
import java.util.Scanner;

// Generate all n-bit vectors of zeroes and ones in lexicographic order.
//Examples
//Input	    Output
//3	        000
//          001
//          010
//          011
//          100
//          101
//          110
//          111
public class RecursiveVectors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Integer[] vector = new Integer[n];

        generateVector(vector, 0);


    }

    private static void printArray(Integer[] vector) {
        for (int j : vector) {
            System.out.print(j);
        }
        System.out.println();
    }

    private static void generateVector(Integer[] vector, int index) {
        if(index >= vector.length)  {
            printArray(vector);
            return;
        }


        for (int i = 0; i <= 1 ; i++) {
            vector[index] = i;
            generateVector(vector, index + 1);
        }

    }
}