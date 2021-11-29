import java.util.Scanner;

public class NChooseKCount {
    //Given an n and k, calculate the number of possible n choose k combinations (without repetition).
    //Examples
    //Input	            Output
    //3                 3
    //2
    //
    //49                13983816
    //6
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        System.out.println(binom(n, k));
    }

    private static int binom(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return binom(n - 1, k - 1) + binom(n - 1, k);

    }
}
