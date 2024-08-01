package pl.adam;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookManagerConsole {
    public static void main(String[] args) throws IOException {
        BookManager bookManager = new BookManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean programStart = true;
        while (programStart) {
            System.out.println("Wybierz co chcesz zrobić: \n 1. Dodaj książkę \n 2. Wyświetl spis książek \n 3. Wyszukaj książkę po tytule \n 4. Zakończ");
            String choice = reader.readLine();
            switch (choice) {
                case "1":
                    System.out.println("Wpisz tytuł książki:");
                    bookManager.addBook(reader.readLine(), reader.readLine());
                    System.out.println("Książka dodana poprawnie!");
                    break;
                case "2":
                    System.out.println("Spis książek:");
                    bookManager.displayList();
                    break;
                case "3":
                    System.out.println("Wpisz tytuł książki, której szukasz:");
                    bookManager.findBook(reader.readLine(), reader.readLine());
                    break;
                case "4":
                    programStart = false;
                    break;
                default:
                    System.out.println("Błąd!  Wpisz na ekran cyfre od 1 - 4");
                    break;
            }
        }
    }
}
