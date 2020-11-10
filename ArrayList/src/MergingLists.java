import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    /*
    You are going to receive two lists with numbers. Create a result list which contains the numbers from both
    of the lists. The first element should be from the first list, the second from the second list and so on.
    If the length of the two lists are not equal, just add the remaining elements at the end of the list.
Example
Input	                         Output
3 5 2 43 12 3 54 10 23
76 5 34 2 4 12	                 3 76 5 5 2 34 43 2 12 4 3 12 54 10 23

76 5 34 2 4 12
3 5 2 43 123 54 10 23	         76 3 5 5 34 2 2 43 4 12 12 3 54 10 23

     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] firstArr = scan.nextLine().split(" ");
        String[] secondArr = scan.nextLine().split(" ");
        
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < firstArr.length; i++) {
            list.add(Integer.parseInt(firstArr[i]));

            if(secondArr.length > i) {
                list.add(Integer.parseInt(secondArr[i]));
            }
        }

        if(secondArr.length > firstArr.length) {
            for (int i = 0; i < secondArr.length - firstArr.length; i++) {
                list.add(Integer.parseInt(secondArr[firstArr.length + i]));
            }
        }

        for (Integer el : list) {
            System.out.print(el + " ");
        }


    }
}
