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

    /**
     * This method converts the title and author name to title case.
     * Each word's first letter will be capitalized.
     */
    public void toTitleCase() {
        this.title = convertToTitleCase(this.title);
        this.author = convertToTitleCase(this.author);
    }

    /**
     * Converts a string into title case (capitalizes the first letter of each word).
     *
     * @param text The string to be converted to title case.
     * @return The title-case string.
     */
    private String convertToTitleCase(String text) {
        String[] words = text.split(" ");
        StringBuilder titleCase = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return titleCase.toString().trim();
    }

    /**
     * This method returns a string representation of the book.
     *
     * @return A string containing the title, author, price, publisher, and ISBN.
     */
    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Price: " + price + "\n" +
                "Publisher: " + publisher + "\n" +
                "ISBN: " + isbn;
    }

    /**
     * This method checks if two Book objects are equal based on their attributes.
     *
     * @param obj The object to compare with.
     * @return true if the two books are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;
        return title.equals(book.title) &&
                author.equals(book.author) &&
                Double.compare(book.price, price) == 0 &&
                publisher.equals(book.publisher) &&
                isbn.equals(book.isbn);
    }

    /**
     * This method creates and returns a clone of the current book object.
     *
     * @return A new Book object with the same attributes as this book.
     */
    @Override
    public Book clone() {
        return new Book(this);
    }

    // Getter and Setter methods

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
