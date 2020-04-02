import java.util.Scanner;

public class TenisRanklist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tournaments = Integer.parseInt(scan.nextLine());
        int startingPoints = Integer.parseInt(scan.nextLine());

        int wCounter = 0;
        int tournamentPoints = 0;

        for (int i = 0; i < tournaments; i++) {

            String result = scan.nextLine();

            switch (result) {
                case "W":
                    tournamentPoints += 2000;
                    wCounter++;
                    break;
                case "F":
                    tournamentPoints += 1200;
                    break;
                case "SF":
                    tournamentPoints += 720;
                    break;
            }
        }

        System.out.printf("Final points: %d%n", (startingPoints + tournamentPoints));
        System.out.printf("Average points: %.0f%n", Math.floor(tournamentPoints * 1.0 / tournaments));
        System.out.printf("%.2f%%", (wCounter * 1.0 / tournaments) * 100);
    }
}
