import java.util.Scanner;

public class HighJump {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int wantedHeight = Integer.parseInt(scan.nextLine());
        int startingHeight = wantedHeight - 30;
        int totalJumps = 0;
        boolean isFailed = false;

        while (startingHeight <= wantedHeight) {

            for (int i = 0; i < 3; i++) {

                int jump = Integer.parseInt(scan.nextLine());
                totalJumps++;


                if (jump > startingHeight) {
                    startingHeight += 5;
                    break;
                }


                if (i == 2) {
                    System.out.printf("Tihomir failed at %dcm after %d jumps.", startingHeight, totalJumps);
                    isFailed = true;
                    break;
                }

            }
            if (isFailed) {
                break;
            }
        }
        if (!isFailed) {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", wantedHeight, totalJumps);
        }
    }
}
