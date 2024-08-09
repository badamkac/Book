package pl.adam;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class BookManagerConsole {
    public static void main(String[] args) throws IOException {
        BookManager bookManager = new BookManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean programStart = true;
        while (programStart) {
            System.out.println("Wybierz co chcesz zrobić: \n 1. Dodaj książkę \n 2. Wyświetl spis książek \n 3. Wyszukaj książkę po tytule \n 4. Wyszukaj książkę po autorze \n 5. Wyszukaj książkę po ISBN \n 6. Zakończ");
            String choice = reader.readLine();
            switch (choice) {
                case "1":
                    System.out.println("Wpisz tytuł a następnie autora książki:");
                    bookManager.addBook(reader.readLine(), reader.readLine());
                    bookManager.displayLastAddedBook();
                    System.out.println("Wprowadzona poprawnie");
                    break;
                case "2":
                    System.out.println("Spis książek:");
                    bookManager.displayList();
                    break;
                case "3":
                    System.out.println("Wpisz tytuł książki, której szukasz:");
                    System.out.println(bookManager.searchBookByTitle(reader.readLine()));
                    break;
                case "4":
                    System.out.println("Wpisz autora książki:");
                    System.out.println(bookManager.searchBookByAuthor(reader.readLine()));
                    break;
                case "5":
                    System.out.println("Wpisz numer ISBN książki:");
                    System.out.println(bookManager.searchBookByIsbn(reader.readLine()));
                    break;
                case "6":
                    programStart = false;
                    break;
                default:
                    System.out.println("Błąd!  Wpisz na ekran cyfre od 1 - 6");
                    break;
            }
        }
    }
}
