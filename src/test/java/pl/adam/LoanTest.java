package pl.adam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    private final Loan loan = new Loan();

    @Test
    void addBookTest(){
        //given
        User user = new User("Adam", "Kowalski", "12345678910");
        Book book = new Book("Pan Tadeusz","Adam Mickiewicz", "12345");
        //when
        loan.addBook(user, book);

        //then
        ArrayList<Book> books =  loan.getBooks(user);
        Assertions.assertNotNull(books);
        Assertions.assertEquals(1,books.size());
        Assertions.assertEquals(book,books.getFirst());
    }
    @Test
    void addTwoBooksTest(){
        //given
        User user = new User("Adam", "Kowalski", "12345678910");
        Book book1 = new Book("Pan Tadeusz","Adam Mickiewicz", "12345");
        Book book2 = new Book("Pan Tadeusz","Adam Mickiewicz", "12345");
        //when
        loan.addBook(user, book1);
        loan.addBook(user, book2);

        //then
        ArrayList<Book> books =  loan.getBooks(user);
        Assertions.assertNotNull(books);
        Assertions.assertEquals(2,books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    void removeBookTest(){
        //given
        User user = new User("Adam", "Kowalski", "12345678910");
        Book book = new Book("Pan Tadeusz","Adam Mickiewicz", "12345");
        loan.addBook(user, book);
        //when
        loan.removeBook(user,book);
        //then
        ArrayList<Book> books = loan.getBooks(user);
        Assertions.assertNotNull(books);
        Assertions.assertEquals(0,books.size());
        assertFalse(books.contains(book));
    }

    @Test
    void removeBookOnNotPresentUserTest(){
        //given
        User user = new User("Adam", "Kowalski", "12345678910");
        Book book = new Book("Pan Tadeusz","Adam Mickiewicz", "12345");

        //when
        loan.removeBook(user,book);
        //then
        ArrayList<Book> books = loan.getBooks(user);
        Assertions.assertNotNull(books);
        Assertions.assertEquals(0,books.size());
        assertFalse(books.contains(book));
    }

}