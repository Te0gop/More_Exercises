package examples;

import java.util.Arrays;

public class FizzBuzz {

    public static void main(String[] args) {

        int[] arr = {60, 5, 6, 8, 13, 1, 25, 44, 65, 100, 125, 132};

        String[] stringArray = new String[arr.length];

        for(int i = 0; i < arr.length; i++) {

            if (arr[i] % 3 == 0 && arr[i] % 5 == 0) {
                stringArray[i] = "fizzbuzz";
            } else if(arr[i] % 3 == 0) {
                stringArray[i] = "fizz";
            } else if (arr[i] % 5 == 0) {
                stringArray[i] = "buzz";
            }

        }

        System.out.println(Arrays.toString(stringArray));
    }
}
