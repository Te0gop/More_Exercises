package task_01_book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }
    private void setTitle(String title) {
        this.title = title;
    }
    private void setYear(int year) {
        this.year = year;
    }
    private void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }
}
