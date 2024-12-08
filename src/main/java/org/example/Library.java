package org.example;

import java.util.ArrayList;

/**
 * This class represents a Library that contains a collection of books.
 * It provides functionalities to search for books by keyword and manage the library's book list.
 *
 * @author Thomas Archambaut
 */
public class Library {
    // Data members
    private ArrayList<Book> books;

    /**
     * Default constructor that initializes the library with 5 default books.
     */
    public Library() {
        books = new ArrayList<>();
        books.add(new Book("How to Speak Chinese", "John Smith", 19.99, "Language Press", "1234567890123"));
        books.add(new Book("The Art of Programming", "Donald Knuth", 89.99, "Tech Books", "9781234567890"));
        books.add(new Book("History of Mathematics", "Mary Johnson", 29.99, "EduBooks", "9789876543210"));
        books.add(new Book("Fictional Worlds", "Emily Bronte", 15.99, "Classic Reads", "9786543210987"));
        books.add(new Book("Understanding Physics", "Richard Feynman", 45.99, "Science Today", "1231231231231"));
    }

    /**
     * Constructor that initializes the library with a given list of books.
     *
     * @param books The list of books to initialize the library with.
     */
    public Library(ArrayList<Book> books) {
        this.books = new ArrayList<>(books);
    }

    /**
     * Copy constructor that creates a new Library object with the same books as another library.
     *
     * @param other The library to copy from.
     */
    public Library(Library other) {
        this.books = new ArrayList<>(other.books);
    }

    /**
     * Searches the library for books containing the specified keyword in their title or author.
     *
     * @param keyword The keyword to search for.
     * @return A list of books that match the search criteria.
     */
    public ArrayList<Book> searchBook(String keyword) {
        ArrayList<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    /**
     * Checks if two Library objects are equal based on their book lists.
     *
     * @param obj The object to compare with.
     * @return true if the libraries are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Library library = (Library) obj;
        return books.equals(library.books);
    }

    /**
     * Returns a string representation of the library and its books.
     *
     * @return A string containing all books in the library.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library contains ").append(books.size()).append(" books:\n");
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    // Getter and Setter methods

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
