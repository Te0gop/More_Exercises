package recursion;

import java.util.Scanner;

// Write a program that draws the figure below depending on n. Use recursion.
//Examples
//Input	            Output
//2	                **
//                  *
//                  #
//                  ##

//5	                *****
//                  ****
//                  ***
//                  **
//                  *
//                  #
//                  ##
//                  ###
//                  ####
//                  #####
public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        recursiveDraw(n);
    }

    private static void recursiveDraw(int n) {

        if(n == 0) {
            return;
        }

        printSymbol('*', n);
        recursiveDraw(n - 1);
        printSymbol('#', n);
    }

    private static void printSymbol(char symbol, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}