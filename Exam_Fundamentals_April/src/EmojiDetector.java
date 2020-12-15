
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("(::)([A-Z]+)[a-z]{2,100}(::)|(\\*\\*)([A-Z]+)[a-z]{2,100}(\\*\\*)");

        Matcher matcher = pattern.matcher(line);

        List<String> emojiList = new ArrayList<>();
        List<Integer> coolness = new ArrayList<>();

        while (matcher.find()) {
            emojiList.add(matcher.group());
        }
        int sum = 1;

        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(line);

        while (digitMatcher.find()) {
            coolness.add(Integer.parseInt(digitMatcher.group()));
            sum *= Integer.parseInt(digitMatcher.group());
        }

        int coolnessSum = 0;

        List<String> coolOnes = new ArrayList<>();

        for (int i = 0; i < emojiList.size(); i++) {
            String emoji = emojiList.get(i);
            for (int j = 0; j < emoji.length(); j++) {
                if (emoji.charAt(j) != '*' && emoji.charAt(j) != ':' && emoji.charAt(j) != ' ') {
                    coolnessSum += emoji.charAt(j);
                }
            }
            if(coolnessSum >= sum) {
                coolOnes.add(emoji);
            }
            coolnessSum = 0;
            }

        System.out.println("Cool threshold: " + sum);
        System.out.printf("%s emojis found in the text. The cool ones are:%n", emojiList.size());
        for (String s : coolOnes) {
            System.out.println(s.trim());
        }
    }
}
