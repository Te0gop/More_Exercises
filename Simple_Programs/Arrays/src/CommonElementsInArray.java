import java.util.Arrays;

public class CommonElementsInArray {
    // Write an array program in java to find common element in array.

    public static void main(String[] args) {
        int[] arry1 = { 1995, 1998, 1986, 1985, 1999, 2000 };
        int[] arry2 = { 1996, 1992, 1988, 2000, 1955, 1999 };

        System.out.println("Array1 ;" + Arrays.toString(arry1));
        System.out.println("Array2 ;" + Arrays.toString(arry2));

        for (int i = 0; i < arry1.length; i++) {
            for (int j = 0; j < arry2.length; j++) {
                if (arry1[i] == arry2[j]) {
                    System.out.println("Common elements are " + arry1[i]);
                }
            }
        }
    }
}
