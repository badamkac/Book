package pl.adam;

import java.util.ArrayList;
import java.util.UUID;

public class BookManager {

    ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(String bookName, String author, UUID isbn) {
        Book book = new Book(bookName, author, isbn);
        bookList.add(book);
    }

    public void displayLastAddedBook(){
        System.out.println(bookList.get(bookList.size() - 1));
    }

    public void displayList() {
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(i + 1 + "." + " " + bookList.get(i));
        }
    }

    public void searchBookByTitle(String bookName) {
        boolean isThere = false;
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookName)) {
                System.out.println(book);
                isThere = true;
            }
        }
        if (!isThere){
            System.out.println("Nie znaleziono książki o podanym tytule");
        }
    }

    public void searchBookByAuthor(String author) {
        boolean isThere = false;
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                isThere = true;
            }
        }
        if (!isThere){
            System.out.println("W spisie nie ma ksiażek tego autora");
        }
    }

    public void searchBookByIsbn(String isbn) {
        boolean isThere = false;
        for (Book book : bookList) {
            if (book.getIsbn().toString().equalsIgnoreCase(isbn)) {
                System.out.println(book);
                isThere = true;
            }
        }
        if (!isThere){
            System.out.println("W spisie nie ma ksiażki o podanym ISBN");
        }
    }

    public void findBook(String bookName, String bookAuthor) {
        boolean isThere = false;
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookName) && book.getAuthor().equalsIgnoreCase(bookAuthor)) {
                isThere = true;
                break;
            }
        }
        if (isThere){
            System.out.println("Twoja książka jest w spisie");
        }else{
            System.out.println("Nie znaleziono książki o podanym tytule");
        }
    }
}