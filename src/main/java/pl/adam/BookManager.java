package pl.adam;

import java.util.ArrayList;
import java.util.UUID;

public class BookManager {

    ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(String bookName, String author, UUID isbn) {
        Book book = new Book(bookName, author, isbn);
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

    public ArrayList<String> searchBookByTitle(String bookName) {
        ArrayList<String> titleList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookName)) {
                titleList.add(book.toString());
            }
        }
        if (!titleList.isEmpty()) {
            return titleList;
        }
        return null;
    }

    public ArrayList<String> searchBookByAuthor(String author) {
        ArrayList<String> authorList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorList.add(book.toString());
            }
        }
        if (!authorList.isEmpty()) {
            return authorList;
        }
        return null;
    }

    public String searchBookByIsbn(String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().toString().equalsIgnoreCase(isbn)) {
                return book.toString();
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