package pl.adam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loan {

    private final HashMap<User, ArrayList<Book>> loanMap = new HashMap<>();

    public void displayLoanInformation(HashMap<User, ArrayList<Book>> loanMap){
        for (Map.Entry<User, ArrayList<Book>> map : loanMap.entrySet()){
            System.out.println(map);
        }
    }

    public void addBook(User user, Book book){
        ArrayList<Book> books = loanMap.getOrDefault(user, new ArrayList<>());
        books.add(book);
        loanMap.putIfAbsent(user, books);
    }

    public ArrayList<Book> getBooks(User user){
        return loanMap.getOrDefault(user, new ArrayList<>());
    }

    public void removeBook(User user, Book book){
        ArrayList<Book> books = loanMap.get(user);
        if (books != null){
            books.remove(book);
        }
    }
}
