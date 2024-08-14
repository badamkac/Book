package pl.adam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loan {

    HashMap<User, ArrayList<Book>> loanMap = new HashMap<>();

    public void displayLoanInformation(HashMap<User, ArrayList<Book>> loanMap){
        for (Map.Entry<User, ArrayList<Book>> map : loanMap.entrySet()){
            System.out.println(map);
        }
    }
}
