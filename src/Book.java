public class Book {
    int id;
    String title;
    String author;
    double price;
    int year;
    int pages;
    String genre;
    boolean available;

    public Book(int id, String title, String author, double price, int year, int pages, String genre, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
        this.pages = pages;
        this.genre = genre;
        this.available = available;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Price: " + price +
                ", Year: " + year + ", Pages: " + pages + ", Genre: " + genre +
                ", Available: " + (available ? "Yes" : "No");
    }
}
