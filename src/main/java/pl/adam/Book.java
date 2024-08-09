package pl.adam;

import java.util.UUID;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;


    public Book(String title, String author, String isbn) {
        this.title = title.toUpperCase();
        this.author = author.toUpperCase();
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Tytuł: " + title + " Author: " + author + " ISBN: " + isbn;
    }
}
