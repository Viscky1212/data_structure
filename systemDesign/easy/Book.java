package systemDesign.easy;

public class Book {

    private final String title;
    private final String author;
    private final String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public boolean borrow() {
        if (!available) {
            return false;
        }

        available = false;
        return true;
    }

    public boolean returnBook() {
        if (available) {
            return false;
        }

        available = true;
        return true;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getInfo() {
        String status = available ? "Available" : "Borrowed";

        return title + " by " + author
                + " (ISBN: " + isbn + ") - " + status;
    }

    public static void main(String[] args) {

        Book book = new Book(
                "Clean Code",
                "Robert Martin",
                "978-0132350884"
        );

        System.out.println(book.getInfo());
        // Clean Code by Robert Martin (ISBN: 978-0132350884) - Available

        System.out.println(book.borrow());
        // true

        System.out.println(book.borrow());
        // false

        System.out.println(book.isAvailable());
        // false

        System.out.println(book.getInfo());
        // Clean Code by Robert Martin (ISBN: 978-0132350884) - Borrowed

        System.out.println(book.returnBook());
        // true

        System.out.println(book.returnBook());
        // false

        System.out.println(book.getInfo());
        // Clean Code by Robert Martin (ISBN: 978-0132350884) - Available
    }
}

