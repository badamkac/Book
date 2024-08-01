package pl.adam;

import java.util.ArrayList;

public class Book {

    private String book;

    public String getBook() {
        return book;
    }

    ArrayList<String> bookList = new ArrayList<String>();

    public void addBook(String bookName) {
        bookList.add(bookName);
    }

    public void displayList() {
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(i + 1 + "." + " " + bookList.get(i));
        }
    }

    public void findBook(String bookName) {
        boolean isThere = false;
        for (String s : bookList) {
            if (s.equalsIgnoreCase(bookName)) {
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