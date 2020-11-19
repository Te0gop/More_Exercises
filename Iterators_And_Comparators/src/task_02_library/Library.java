package task_02_library;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Library implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }


    @Override
    public Iterator<Book> iterator() {
        return new Iterator<>() {
            private int index = books.length - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Book next() {
                return books[index--];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Book> action) {

    }

    @Override
    public Spliterator<Book> spliterator() {
        return null;
    }
}
