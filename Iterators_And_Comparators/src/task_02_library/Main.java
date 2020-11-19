package task_02_library;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Book[] books = {bookOne, bookTwo, bookThree};

        Library library = new Library(books);

        System.out.println("Lib iterator:");
        for (Book book : library) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println("For loop:");

        for (Book book : books) {
            System.out.println(book);
        }

    }

}
