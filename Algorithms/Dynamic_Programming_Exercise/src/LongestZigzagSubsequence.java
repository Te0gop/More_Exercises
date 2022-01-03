import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class LongestZigzagSubsequence {
    //A zigzag sequence is one that alternately increases and decreases. More formally, such a sequence has to comply with one of the two rules below:
    //1)	Every even element is smaller than its neighbors and every odd element is larger than its neighbors, or
    //2)	Every odd element is smaller than its neighbors and every even element is larger than its neighbors
    //1 3 2 is a zigzag sequence, but 1 2 3 is not. Any sequence of one or two elements is zig zag.
    //Find the longest zigzag subsequence in a given sequence.
    //Examples
    //Input                                         	Output
    //8 3 5 7 0 8 9 10 20 20 20 12 19 11	            8 3 5 0 20 12 19 11
    //1 2 3	                                            1 2
    //1 3 2	                                            1 3 2
    //24 5 31 3 3 342 51 114 52 55 56 58	            24 5 31 3 342 51 114 52 55

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[numbers.length + 1][2];
        int[][] prev = new int[numbers.length + 1][2];

        //Are greater
        dp[0][0] = 1;
        //Are lesser
        dp[0][1] = 1;

        prev[0][0] = -1;
        prev[0][1] = -1;

        int maxLength = 0;

        int[] best = new int[2];

        for (int currIndex = 0; currIndex < numbers.length; currIndex++) {
            int currentNumber = numbers[currIndex];

            for (int prevIndex = currIndex - 1; prevIndex >= 0; prevIndex--) {
                int prevNumber = numbers[prevIndex];

                if (currentNumber > prevNumber && dp[currIndex][0] <= dp[prevIndex][1] + 1) {
                    dp[currIndex][0] = dp[prevIndex][1] + 1;
                    prev[currIndex][0] = prevIndex;
                }
                if (currentNumber < prevNumber && dp[currIndex][1] <= dp[prevIndex][0] + 1) {
                    dp[currIndex][1] = dp[prevIndex][0] + 1;
                    prev[currIndex][1] = prevIndex;
                }
            }

            if (maxLength < dp[currIndex][0]) {
                maxLength = dp[currIndex][0];
                best[0] = currIndex;
                best[1] = 0;
            } else if (maxLength < dp[currIndex][1]) {
                maxLength = dp[currIndex][1];
                best[0] = currIndex;
                best[1] = 1;
            }

        }

        Deque<Integer> zigZagSequence = new ArrayDeque<>();
        int beginRow = best[0];

        while (beginRow >= 0) {
            zigZagSequence.push(numbers[beginRow]);

            beginRow = prev[beginRow][best[1]];
            best[1] = best[1] == 0 ? 1 : 0;
        }
        while (!zigZagSequence.isEmpty()) {
            System.out.print(zigZagSequence.pop() + " ");
        }
    }
}
