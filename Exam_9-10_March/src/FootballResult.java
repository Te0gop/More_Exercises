import java.util.Scanner;

public class FootballResult {
    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        String firstGame = scan.nextLine();
        String secondGame = scan.nextLine();
        String thirdGame = scan.nextLine();

        int resultFirstTeam = firstGame.charAt(0);
        int resultSecondTeam = firstGame.charAt(2);

        int win = 0;
        int lose = 0;
        int even = 0;

        if (resultFirstTeam > resultSecondTeam) {
            win++;
        }
        else if (resultSecondTeam > resultFirstTeam) {
            lose++;
        } else {
            even++;
        }
        int resultFirstTeam2 = secondGame.charAt(0);
        int resultSecondTeam2 = secondGame.charAt(2);

        if (resultFirstTeam2 > resultSecondTeam2) {
            win++;
        }
        else if (resultSecondTeam2 > resultFirstTeam2) {
            lose++;
        } else {
            even++;
        }
        int resultFirstTeam3 = thirdGame.charAt(0);
        int resultSecondTeam3 = thirdGame.charAt(2);

        if (resultFirstTeam3 > resultSecondTeam3) {
            win++;
        }
        else if (resultSecondTeam3 > resultFirstTeam3) {
            lose++;
        } else {
            even++;
        }

        System.out.printf("Team won %d games.%n", win);
        System.out.printf("Team lost %d games.%n", lose);
        System.out.printf("Drawn games: %d%n", even);


    }
}
