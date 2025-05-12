import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/book_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Book Search App ---");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Add New Book");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewAllBooks();
                case 2 -> {
                    System.out.print("Enter title to search: ");
                    String title = scanner.nextLine();
                    searchBookByTitle(title);
                }
                case 3 -> addNewBook(scanner);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void viewAllBooks() {
        String query = "SELECT * FROM books";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("year"),
                        rs.getInt("pages"),
                        rs.getString("genre"),
                        rs.getBoolean("available")
                ));
            }

            if (books.isEmpty()) {
                System.out.println("No books found.");
            } else {
                books.forEach(System.out::println);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void searchBookByTitle(String title) {
        String query = "SELECT * FROM books WHERE title LIKE ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();

            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("year"),
                        rs.getInt("pages"),
                        rs.getString("genre"),
                        rs.getBoolean("available")
                ));
            }

            if (books.isEmpty()) {
                System.out.println("No matching books found.");
            } else {
                books.forEach(System.out::println);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addNewBook(Scanner scanner) {
        try (Connection conn = connect()) {
            String query = "INSERT INTO books (title, author, price, year, pages, genre, available) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            System.out.print("Year: ");
            int year = scanner.nextInt();

            System.out.print("Pages: ");
            int pages = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            System.out.print("Available (true/false): ");
            boolean available = scanner.nextBoolean();

            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setDouble(3, price);
            stmt.setInt(4, year);
            stmt.setInt(5, pages);
            stmt.setString(6, genre);
            stmt.setBoolean(7, available);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Book added successfully.");
            } else {
                System.out.println("Failed to add book.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
