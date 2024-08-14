package pl.adam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LibraryManagerTest {
    @Test
    void addBookTest(){
        //given
        String bookName = "Przyjaciele";
        String author = "Adam Mickiewicz";
        LibraryManager libraryManager = new LibraryManager();
        //when
        libraryManager.addBook(bookName, author);
        //then
        Book book = libraryManager.findBook(bookName,author);
        Assertions.assertNotNull(book);
        Assertions.assertEquals(bookName, book.getTitle());
        Assertions.assertEquals(author, book.getAuthor());
        Assertions.assertNotNull(book.getIsbn());
    }
    @Test
    void editBookByIsbnTest(){
        //given
        LibraryManager libraryManager = new LibraryManager();
        String bookName = "Przyjaciele";
        String oldAuthor = "Adam Mickiewicz";
        String newAuthor = "Bolek";
        libraryManager.addBook(bookName,oldAuthor);
        String isbn = libraryManager.findBook(bookName,oldAuthor).getIsbn();
        //when
        libraryManager.editBookByIsbn(isbn, bookName,newAuthor);

        //then
        Book editedBook = libraryManager.findBook(bookName,newAuthor);
        Assertions.assertNotNull(editedBook);
        Assertions.assertNull(libraryManager.findBook(bookName,oldAuthor));
        Assertions.assertEquals(bookName, editedBook.getTitle());
        Assertions.assertEquals(newAuthor, editedBook.getAuthor());
        Assertions.assertEquals(isbn, editedBook.getIsbn());
    }

}