import java.util.*;

public class Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int[] arr = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        Arrays.stream(arr).forEach(list::add);
        Arrays.stream(arr)
                .mapToDouble(e -> e)
                .average()
                .stream().boxed()
                .forEach(avgSum -> {
                    list.removeIf(i -> i <= avgSum);
                });

        Collections.sort(list);
        Collections.reverse(list);

        if(arr.length == 1 || list.isEmpty()) {
            System.out.println("No");
        } else if (list.size() > 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(list.get(i) + " ");
            }
        } else {
            list.forEach(e -> System.out.print(e + " "));
        }
    }
}
