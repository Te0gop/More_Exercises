import java.util.*;
import java.util.stream.Collectors;

public class LootBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> claimedItems = new ArrayDeque<>();
        boolean isEmpty = false;

        while(!firstBox.isEmpty()) {

            if ((firstBox.getFirst() + secondBox.getLast()) % 2 == 1) {
                firstBox.add(secondBox.getLast());
            } else {
                claimedItems.add(firstBox.getFirst() + secondBox.getLast());
                firstBox.removeFirst();
            }
            secondBox.removeLast();

            if (secondBox.size() == 0) {
                System.out.println("Second lootbox is empty");
                isEmpty = true;
                break;
            }
        }
        if (!isEmpty) {
            System.out.println("First lootbox is empty");
        }

        int maxValue = claimedItems
                .stream()
                .mapToInt(e -> e)
                .sum();


        if (maxValue >= 100) {
            System.out.println("Your loot was epic! Value: " + maxValue);
        } else {
            System.out.println("Your loot was poor... Value: " + maxValue);
        }

    }
}
