import java.util.Scanner;

public class oscarWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movieName = scan.nextLine();
        String hallType = scan.nextLine();
        int tickets = scan.nextInt();
        double ticketPrice = 0;

        if (movieName.equals("A Star Is Born")) {
            switch (hallType) {
                case "normal":
                    ticketPrice = 7.50 * tickets;
                    break;
                case "luxury":
                    ticketPrice = 10.50 * tickets;
                    break;
                case "ultra luxury":
                    ticketPrice = 13.50 * tickets;
                    break;
                default:
                    break;
            }
        }
        else if (movieName.equals("Bohemian Rhapsody")) {
            switch (hallType) {
                case "normal":
                    ticketPrice = 7.35 * tickets;
                    break;
                case "luxury":
                    ticketPrice = 9.45 * tickets;
                    break;
                case "ultra luxury":
                    ticketPrice = 12.75 * tickets;
                    break;
                default:
                    break;
            }
        }
        else if (movieName.equals("Green Book")) {
            switch (hallType) {
                case "normal":
                    ticketPrice = 8.15 * tickets;
                    break;
                case "luxury":
                    ticketPrice = 10.25 * tickets;
                    break;
                case "ultra luxury":
                    ticketPrice = 13.25 * tickets;
                    break;
                default:
                    break;
            }
        }
        else if (movieName.equals("The Favourite")) {
            switch (hallType) {
                case "normal":
                    ticketPrice = 8.75 * tickets;
                    break;
                case "luxury":
                    ticketPrice = 11.55 * tickets;
                    break;
                case "ultra luxury":
                    ticketPrice = 13.95 * tickets;
                    break;
                default:
                    break;
            }
        }
        System.out.printf("%s -> %.2f lv.", movieName, ticketPrice);
    }
}
