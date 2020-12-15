import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();

        String command;

        while(!(command = scanner.nextLine()).equals("Generate")) {

            String[] delimiter = command.split(">>>");

            String operation = delimiter[0];

            switch (operation) {
                case "Contains":
                    String sequence = delimiter[1];
                    if(key.contains(sequence)) {
                        System.out.println(key + " contains " + sequence);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    String upperOrLower = delimiter[1];
                    String firstIndex = delimiter[2];
                    String secondIndex = delimiter[3];
                    if(upperOrLower.equals("Upper")) {
                        String upperCase = key.substring(Integer.parseInt(firstIndex), Integer.parseInt(secondIndex))
                                .toUpperCase();
                        key = key.replace(upperCase.toLowerCase(), upperCase);
                    } else {
                        String lower = key.substring(Integer.parseInt(firstIndex), Integer.parseInt(secondIndex));
                            key = key.replace(lower, lower.toLowerCase());
                    }
                    System.out.println(key);
                    break;

                case "Slice":
                    String startIndex = delimiter[1];
                    String endIndex = delimiter[2];
                    String deletedSequence = key.substring(Integer.parseInt(startIndex), Integer.parseInt(endIndex));
                    key = key.replace(deletedSequence, "");
                    System.out.println(key);
                    break;
            }
        }
        System.out.println("Your activation key is: " + key);
    }
}
