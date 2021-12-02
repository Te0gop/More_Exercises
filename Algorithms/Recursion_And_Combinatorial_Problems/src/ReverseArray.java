import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseArray {
   // Write a program that reverses and prints an array. Use recursion.
    //Examples
    //Input	                Output
    //1 2 3 4 5 6	        6 5 4 3 2 1

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split("\\s+");

        printReversedArray(elements, elements.length - 1);

    }

    private static void printReversedArray(String[] elements, int index) {
        if(index < 0) {
            return;
        }
        System.out.print(elements[index] + " ");
        printReversedArray(elements, index - 1);
    }
}
