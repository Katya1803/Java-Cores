package oops;

import a.example.Example;

public class OOPExample implements Example {
    @Override
    public void run() {
        Library library = new Library();

        Book book1 = new Book(1, "Effective Java", "Joshua Bloch");
        Book book2 = new Book(2, "Clean Code", "Robert C. Martin");
        Book book3 = new Book(3, "Java Concurrency in Practice", "Brian Goetz");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("\nList of books in library:");
        library.listBooks();

        System.out.println("\nBorrowing book with ID 2:");
        library.borrowBook(2);

        System.out.println("\nList of books in library after borrowing:");
        library.listBooks();

        System.out.println("\nReturning book with ID 2:");
        library.returnBook(2);

        System.out.println("\nList of books in library after returning:");
        library.listBooks();

        System.out.println("\nRemoving book with ID 3:");
        library.removeBook(3);

        System.out.println("\nList of books in library after removing:");
        library.listBooks();
    }
}
