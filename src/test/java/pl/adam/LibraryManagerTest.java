package pl.adam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    void addUserTest(){
        //given
        LibraryManager libraryManager = new LibraryManager();
        User user = new User("Adam", "Kowalski","0123456789");
        //when
        libraryManager.addUser(user.getUserFirstName(),user.getUserLastName(),user.getPesel());
        //then
        User searchUser = libraryManager.searchUserById(user.getPesel());
        Assertions.assertNotNull(searchUser);
        Assertions.assertEquals(user.getPesel(),searchUser.getPesel());
        Assertions.assertEquals(searchUser,user);
    }

    @Test
    void addUserShouldBeUniquePeselTest(){
        //given
        LibraryManager libraryManager = new LibraryManager();
        String pesel = "0123456789";
        User user1 = new User("Adam", "Kowalski", pesel);
        User user2 = new User("Paweł", "Kowalski", pesel);

        //when
        libraryManager.addUser(user1.getUserFirstName(),user1.getUserLastName(), pesel);
        libraryManager.addUser(user2.getUserFirstName(),user2.getUserLastName(), pesel);
        //then
        ArrayList<User> userList = libraryManager.getAllUsers();
        Assertions.assertEquals(1,userList.size());
        Assertions.assertEquals(user1,userList.getFirst());
    }

    @Test
    void usersInLibraryShouldBeEmptyAtStart(){
        //given
        LibraryManager libraryManager = new LibraryManager();
        //when

        //then
        ArrayList<User> userList = libraryManager.getAllUsers();
        Assertions.assertEquals(0,userList.size());
    }

    @Test
    void loanBookTest(){
        //given
        LibraryManager libraryManager = new LibraryManager();
        User user = libraryManager.addUser("Adam", "Kowalski", "0123456789");
        Book book = libraryManager.addBook("Pan Tadeusz", "Adam Mickiewicz");
        //when
        libraryManager.loanBook(user.getPesel(), book.getIsbn());

        //then
        Assertions.assertFalse(libraryManager.searchBookByTitle(book.getTitle()).contains(book));
        Assertions.assertTrue(libraryManager.getLoanedBooks(user).contains(book));
    }

    @Test
    void returnBook(){
        //given
        LibraryManager libraryManager = new LibraryManager();
        User user = libraryManager.addUser("Adam", "Kowalski", "0123456789");
        Book book = libraryManager.addBook("Pan Tadeusz", "Adam Mickiewicz");
        libraryManager.loanBook(user.getPesel(),book.getIsbn());
        //when
        libraryManager.returnBook(user.getPesel(), book.getIsbn());

        //then
        Assertions.assertFalse(libraryManager.getLoanedBooks(user).contains(book));
        Assertions.assertTrue(libraryManager.searchBookByTitle(book.getTitle()).contains(book));
    }


}