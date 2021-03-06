package task_2;

public class Book {
    private String title;
    private String author;
    private double price;


    public Book(String author, String title, double price) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String[] delimiter = author.split(" ");
        if(delimiter.length == 2 && Character.isDigit(delimiter[1].charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    public String toString() {
        return "Type: " + getClass().getSimpleName() + "\n"
                + "Title: " + getTitle()  + "\n"
                + "Author: " + getAuthor()  + "\n"
                + "Price: " + getPrice()  + "\n";
    }
//    public String toString() {
//    final StringBuilder sb = new StringBuilder();
//    sb.append("Type: ").append(this.getClass().getSimpleName())
//            .append(System.lineSeparator())
//            .append("Title: ").append(this.getTitle())
//            .append(System.lineSeparator())
//            .append("Author: ").append(this.getAuthor())
//            .append(System.lineSeparator())
//            .append("Price: ").append(this.getPrice())
//            .append(System.lineSeparator());
//    return sb.toString();
//    }
}
