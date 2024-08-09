package pl.adam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {
    @Test
    void addBookTest(){
        //given
        String bookName = "Przyjaciele";
        String author = "Adam Mickiewicz";
        BookManager bookManager = new BookManager();
        //when
        bookManager.addBook(bookName, author);
        //then
        Book book = bookManager.findBook(bookName,author);
        Assertions.assertNotNull(book);
        Assertions.assertEquals(bookName, book.getTitle());
        Assertions.assertEquals(author, book.getAuthor());
        Assertions.assertNotNull(book.getIsbn());
    }
    @Test
    void editBookByIsbnTest(){
        //given
        BookManager bookManager = new BookManager();
        String bookName = "Przyjaciele";
        String oldAuthor = "Adam Mickiewicz";
        String newAuthor = "Bolek";
        bookManager.addBook(bookName,oldAuthor);
        String isbn = bookManager.findBook(bookName,oldAuthor).getIsbn();
        //when
        bookManager.editBookByIsbn(isbn, bookName,newAuthor);

        //then
        Book editedBook = bookManager.findBook(bookName,newAuthor);
        Assertions.assertNotNull(editedBook);
        Assertions.assertNull(bookManager.findBook(bookName,oldAuthor));
        Assertions.assertEquals(bookName, editedBook.getTitle());
        Assertions.assertEquals(newAuthor, editedBook.getAuthor());
        Assertions.assertEquals(isbn, editedBook.getIsbn());
    }

}