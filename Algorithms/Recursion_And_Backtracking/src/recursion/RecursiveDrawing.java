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
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        recursiveDraw(n - 1);
        recursiveDrawHashtags(n);
    }

    private static void recursiveDrawHashtags(int n) {
        int index = 0;
        if(n == index) {
            System.out.println();
            return;
        }

        System.out.print("#");
        recursiveDrawHashtags(n - 1);
    }
}