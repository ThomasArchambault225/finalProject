package org.example;

/**
 * This class represents a Book with details such as title, author, price, publisher, and ISBN.
 * The ISBN can be validated as either ISBN-10 or ISBN-13 format.
 *
 * @author Thomas Archambaut
 */
public class Book {
    // Data members
    private String title;
    private String author;
    private double price;
    private String publisher;
    private String isbn;

    // Constants for ISBN lengths
    private static final int ISBN10_LENGTH = 13;
    private static final int ISBN13_LENGTH = 17;

    /**
     * Default constructor initializing default values for the book.
     */
    public Book() {
        this.title = "Untitled";
        this.author = "Unknown Author";
        this.price = 0.0;
        this.publisher = "To be confirmed";
        this.isbn = "0000000000000";
    }

    /**
     * Constructor initializing the book with a title.
     *
     * @param title The title of the book.
     */
    public Book(String title) {
        this.title = title;
        this.author = "Unknown Author";
        this.price = 0.0;
        this.publisher = "To be confirmed";
        this.isbn = "0000000000000";
    }

    /**
     * Constructor initializing the book with all data members.
     *
     * @param title    The title of the book.
     * @param author   The author of the book.
     * @param price    The price of the book.
     * @param publisher The publisher of the book.
     * @param isbn     The ISBN of the book.
     */
    public Book(String title, String author, double price, String publisher, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    /**
     * Copy constructor to create a new Book object with the same attributes as another book.
     *
     * @param other The other Book object to copy from.
     */
    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.price = other.price;
        this.publisher = other.publisher;
        this.isbn = other.isbn;
    }

    /**
     * This method checks the validity of the ISBN based on the length and format.
     * Returns 0 if the ISBN is valid ISBN-10, 1 if valid ISBN-13, -1 if invalid.
     *
     * @return int indicating the status of the ISBN.
     */
    public int checkIsbnStatus() {
        if (isbn.length() == ISBN10_LENGTH) {
            return 0; // Valid ISBN-10
        } else if (isbn.length() == ISBN13_LENGTH) {
            return 1; // Valid ISBN-13
        } else {
            return -1; // Invalid ISBN
        }
    }

