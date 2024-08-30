package pl.adam;

import java.util.ArrayList;
import java.util.UUID;

public class LibraryManager {

    private final ArrayList<Book> bookList = new ArrayList<>();
    private final ArrayList<User> userList = new ArrayList<>();
    private final Loan loan = new Loan();

    //User Manager
    public User addUser(String userFirstName, String userLastName, String pesel){
        User user = new User(userFirstName, userLastName, pesel);
        if (searchUserById(pesel) == null)
            userList.add(user);
        return user;
    }

    public User searchUserById(String userID){
        for (User user : userList){
            if(user.getPesel().equalsIgnoreCase(userID)){
                return user;
            }
        }
        return null;
    }

    public void displayCurrentUser() {
        System.out.println(userList.get(userList.size() - 1));
    }

    public ArrayList<User> getAllUsers() {
        return userList;
    }


    //Book Manager

    public void loanBook(String userID, String bookIsbn){
        User user = searchUserById(userID);
        Book book = searchBookByIsbn(bookIsbn);
        bookList.remove(book);
        loan.addBook(user, book);
    }

    public void returnBook(String userID, String bookIsbn) {
        User user = searchUserById(userID);
        Book book = searchLoanedBookByIsbn(bookIsbn, user);
        loan.removeBook(user, book);
        bookList.add(book);
    }

    public ArrayList<Book> getLoanedBooks(User user){
        return loan.getBooks(user);
    }

    public Book addBook(String bookName, String author) {
        String id = UUID.randomUUID().toString();
        Book book = new Book(bookName, author, id);
        bookList.add(book);
        return book;
    }

    public void displayLastAddedBook() {
        System.out.println(bookList.get(bookList.size() - 1));
    }

    public void displayList(ArrayList<Book> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + "." + " " + list.get(i));
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

    public Book searchLoanedBookByIsbn(String isbn, User user) {
        for (Book book : getLoanedBooks(user)) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }


    public Book findBook(String bookName, String bookAuthor) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookName) && book.getAuthor().equalsIgnoreCase(bookAuthor)) {
                return book;
            }
        }
        return null;
    }

    public void editBookByIsbn(String isbn, String newBookName, String newAuthor){
        Book newBook = new Book(newBookName,newAuthor,isbn);
        bookList.remove(searchBookByIsbn(isbn));
        bookList.add(newBook);
    }


}