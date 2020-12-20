import java.util.*;
import java.util.stream.Collectors;

public class Bombs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffect = Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasing = Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, List<Integer>> map = new TreeMap<>();
        boolean isFull = false;

        while(!bombEffect.isEmpty() && !bombCasing.isEmpty()) {

            int casing = bombCasing.getLast();
            int effect = bombEffect.getFirst();

            while (casing + effect != 120 || casing + effect != 60 || casing + effect != 40) {

                if (casing + effect == 120) {
                    if(!map.containsKey("Smoke Decoy Bombs")) {
                        map.put("Smoke Decoy Bombs", new ArrayList<>() {{add(120);}});
                    } else {
                        map.get("Smoke Decoy Bombs").add(120);
                    }
                    bombEffect.pop();
                    bombCasing.pollLast();
                    break;
                } else if (casing + effect == 60) {
                    if(!map.containsKey("Cherry Bombs")) {
                        map.put("Cherry Bombs", new ArrayList<>() {{add(60);}});
                    } else {
                        map.get("Cherry Bombs").add(60);
                    }
                    bombEffect.pop();
                    bombCasing.pollLast();
                    break;
                } else if (casing + effect == 40) {
                    if(!map.containsKey("Datura Bombs")) {
                        map.put("Datura Bombs", new ArrayList<>() {{add(40);}});
                    } else {
                        map.get("Datura Bombs").add(40);
                    }
                    bombEffect.pop();
                    bombCasing.pollLast();
                    break;
                } else {
                    effect -= 5;
                }
            }

            if(map.get("Smoke Decoy Bombs") != null && map.get("Cherry Bombs") != null
                    && map.get("Datura Bombs") != null) {
                if(map.get("Smoke Decoy Bombs").size() >= 3 && map.get("Cherry Bombs").size() >= 3
                        && map.get("Datura Bombs").size() >= 3) {
                    isFull = true;
                    break;
                }
            }

        }

        if(isFull) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if(bombEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
           String s = bombEffect.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bomb Effects: " + s);
        }

        if(bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            String s = bombCasing.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bomb Casings: " + s);
        }

        if(map.get("Cherry Bombs") == null) {
            System.out.println("Cherry Bombs: 0");
        } else {
            System.out.println("Cherry Bombs: " + map.get("Cherry Bombs").size());
        }
        if(map.get("Datura Bombs") == null) {
            System.out.println("Datura Bombs: 0");
        } else {
            System.out.println("Datura Bombs: " + map.get("Datura Bombs").size());
        }
        if(map.get("Smoke Decoy Bombs") == null) {
            System.out.println("Smoke Decoy Bombs: 0");
        } else {
            System.out.println("Smoke Decoy Bombs: " + map.get("Smoke Decoy Bombs").size());
        }

    }
}
