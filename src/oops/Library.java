package oops;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book);
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getId() == bookId);
        System.out.println("Removed book with ID: " + bookId);
    }

    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Borrowed: " + book);
                return;
            }
        }
        System.out.println("Book with ID: " + bookId + " is not available.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Returned: " + book);
                return;
            }
        }
        System.out.println("Book with ID: " + bookId + " is not borrowed.");
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
