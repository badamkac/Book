package pl.adam;

import java.util.ArrayList;

public class BookManager {

    ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(String bookName, String author) {
        Book book = new Book(bookName, author);
        bookList.add(book);
    }

    public void displayList() {
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(i + 1 + "." + " " + bookList.get(i));
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
//        if (bookList.contains(bookName)) {
//            System.out.println("Twoja książka jest w spisie na miejscu " + (bookList.indexOf(bookName) + 1));
//        } else {
//            System.out.println("Nie znaleziono książki o podanym tytule");
//        }
    }
}