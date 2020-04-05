package task_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            String author = scan.nextLine();
            String title = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Book book = new Book(author, title, price);
            GoldenEditionBook goldBook = new GoldenEditionBook(author, title, price);
            System.out.println(book);
            System.out.println(goldBook);


        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
