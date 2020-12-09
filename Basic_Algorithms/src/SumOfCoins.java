import java.util.*;
import java.util.stream.Collectors;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] elements = in.nextLine().substring(7).split(", ");

        int[] coins = new int[elements.length];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }
    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        List<Integer> sortedCoins = Arrays.stream(coins)
                .boxed()
                .sorted((f, s) -> Integer.compare(s, f))
                .collect(Collectors.toList());

        int coinIndex = 0;

        Map<Integer, Integer> resultMap = new LinkedHashMap<>();

        while (targetSum > 0) {
            int coin = sortedCoins.get(coinIndex++);

            int coinsToTake = targetSum / coin;

            targetSum %= coin;

            if (coinsToTake != 0) {
                resultMap.put(coin, coinsToTake);
            }
        }
        return resultMap;
    }
}
