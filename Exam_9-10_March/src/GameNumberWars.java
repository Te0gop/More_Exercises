import java.util.Scanner;

public class GameNumberWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstPlayer = scan.nextLine();
        String secondPlayer = scan.nextLine();

        int firstPlayerPoints = 0;
        int secondPlayerPoints = 0;
        boolean isNumberWars = false;
        String firstPlayerCard = scan.nextLine();


        while (!"End of game".equals(firstPlayerCard)) {
         String secondPlayerCard = scan.nextLine();
         int firstCard = Integer.parseInt(firstPlayerCard);
         int secondCard = Integer.parseInt(secondPlayerCard);

         if (firstCard > secondCard) {
             firstPlayerPoints += firstCard - secondCard;
         } else if (secondCard > firstCard) {
             secondPlayerPoints += secondCard - firstCard;
         } else {
             firstCard = Integer.parseInt(scan.nextLine());
             secondCard = Integer.parseInt(scan.nextLine());

             System.out.println("Number wars!");

             if (firstCard > secondCard) {
                 System.out.printf("%s is winner with %d points", firstPlayer, firstPlayerPoints);

             } else {
                 System.out.printf("%s is winner with %d points", secondPlayer, secondPlayerPoints);

             }
             isNumberWars = true;
             break;
         }
            if (isNumberWars) {
                break;
            }
            firstPlayerCard = scan.nextLine();
        }
        if (!isNumberWars) {
            System.out.printf("%s has %d points %n", firstPlayer, firstPlayerPoints);
            System.out.printf("%s has %d points %n", secondPlayer, secondPlayerPoints);
        }
    }
}
