package pl.adam;

import java.util.ArrayList;
import java.util.UUID;

public class BookManager {

    ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(String bookName, String author) {
        String id = UUID.randomUUID().toString();
        Book book = new Book(bookName, author, id);
        bookList.add(book);
    }

    public void displayLastAddedBook() {
        System.out.println(bookList.get(bookList.size() - 1));
    }

    public void displayList() {
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(i + 1 + "." + " " + bookList.get(i));
        }
    }

    public ArrayList<Book> searchBookByTitle(String bookName) {
        ArrayList<Book> titleList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookName)) {
                titleList.add(book);
            }
        }
        return titleList;
    }

    public ArrayList<Book> searchBookByAuthor(String author) {
        ArrayList<Book> authorList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorList.add(book);
            }
        }
        return authorList;
    }

    public Book searchBookByIsbn(String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void findBook(String bookName, String bookAuthor) {
        boolean isThere = false;
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookName) && book.getAuthor().equalsIgnoreCase(bookAuthor)) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            System.out.println("Twoja książka jest w spisie");
        } else {
            System.out.println("Nie znaleziono książki o podanym tytule");
        }
    }
}