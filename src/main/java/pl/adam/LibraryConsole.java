package pl.adam;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LibraryConsole {
    public static void main(String[] args) throws IOException {
        LibraryManager libraryManager = new LibraryManager();
        Loan loanInformation = new Loan();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean programStart = true;
        while (programStart) {
            System.out.println("Wybierz co chcesz zrobić: \n 1. Dodaj książkę \n 2. Wyświetl spis książek \n 3. Dodaj użytkownika \n 4. Wypożycz książkę \n 6. Zwróć książkę \n 7. Wyszukaj książkę po autorze \n 8. Wyszukaj książkę po ISBN \n 9. Zakończ");
            String choice = reader.readLine();
            switch (choice) {
                case "1":
                    System.out.println("Wpisz tytuł a następnie autora książki:");
                    libraryManager.addBook(reader.readLine(), reader.readLine());
                    libraryManager.displayLastAddedBook();
                    System.out.println("Wprowadzona poprawnie");
                    break;
                case "2":
                    System.out.println("Spis książek dostępnych:");
                    libraryManager.displayList(libraryManager.bookList);
                    System.out.println("Książki wypożyczone:");
                    libraryManager.displayList(libraryManager.loanBookList);
                    break;
                case "3":
                    System.out.println("Wprowadź imie, nazwisko i PESEL:");
                    libraryManager.addUser(reader.readLine(), reader.readLine(), reader.readLine());
                    libraryManager.displayCurrentUser();
                    break;
                case "4":
                    System.out.println("Wprowadź PESEL użytkownika:");
                    User currentUser = libraryManager.searchUserById(reader.readLine());
                    System.out.println(currentUser);
                    System.out.println("Wprowadź tytuł i autora książki, którą chcesz wypożyczyć:");
                    Book loanBook = libraryManager.findBook(reader.readLine(), reader.readLine());
                    libraryManager.loanBookList.add(loanBook);
                    libraryManager.bookList.remove(loanBook);
                    libraryManager.loanBook(currentUser,libraryManager.loanBookList);
                    loanInformation.loanMap.put(currentUser,libraryManager.loanBookList);
                    break;
                case "5":
                    System.out.println("Wprowadź PESEL użytkownika:");
                    currentUser = libraryManager.searchUserById(reader.readLine());
                    System.out.println(currentUser);
                    System.out.println("Wprowadź tytuł i autora książki, którą chcesz zwrócić:");
                    loanBook = libraryManager.findBook(reader.readLine(), reader.readLine());
                    libraryManager.bookList.add(loanBook);
                    libraryManager.loanBookList.remove(loanBook);
                    libraryManager.loanBook(currentUser,libraryManager.loanBookList);
                    break;
                case "6":
                    System.out.println("Wpisz tytuł książki, której szukasz:");
                    System.out.println(libraryManager.searchBookByTitle(reader.readLine()));
                    break;
                case "7":
                    System.out.println("Wpisz autora książki:");
                    System.out.println(libraryManager.searchBookByAuthor(reader.readLine()));
                    break;
                case "8":
                    System.out.println("Wpisz numer ISBN książki:");
                    System.out.println(libraryManager.searchBookByIsbn(reader.readLine()));
                    break;
                case "9":
                    programStart = false;
                    break;
                default:
                    System.out.println("Błąd!  Wpisz na ekran cyfre od 1 - 6");
                    break;
            }
        }
    }
}
