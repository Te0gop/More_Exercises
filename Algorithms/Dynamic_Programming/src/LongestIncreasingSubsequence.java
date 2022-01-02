import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    //Let’s have a sequence of numbers S = {a1, a2, … an}. An increasing subsequence is a sequence of numbers
    // within S where each number is larger than the previous. We do not change the relative positions of the
    // numbers, e.g. we do not move smaller elements to the left to obtain longer sequences. If several sequences
    // with equal length exist, find the left-most of them
    //Examples
    //Input	                Output
    //1 2 5 3 4	            1 2 3 4
    //4 3 2 1	            4
    //4 2 -1 3 5 5	        2 3 5

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] sequence = {3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1};
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];

        Arrays.fill(prev, -1);

        int maxLength = 0, maxIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            int bestLength = 1;
            int bestIndex = -1;

            for (int j = i; j >= 0; j--) {
                if(sequence[j] < current && length[j] + 1 >= bestLength) {
                    bestLength = length[j] + 1;
                    bestIndex = j;
                }
            }
            prev[i] = bestIndex;
            length[i] = bestLength;

            if(bestLength > maxLength) {
                maxLength = bestLength;
                maxIndex = i;
            }
        }

        List<Integer> LIS = new ArrayList<>();


        int index = maxIndex;

        while (index != -1) {
            LIS.add(sequence[index]);
            index = prev[index];
        }

        for (int i = LIS.size() - 1; i >= 0 ; i--) {
            System.out.print(LIS.get(i) + " ");
        }
    }
}
