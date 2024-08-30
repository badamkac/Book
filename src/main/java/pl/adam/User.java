package pl.adam;

import java.util.Objects;

public class User {
    private final String userFirstName;
    private final String userLastName;
    private final String pesel;

    public User(String userFirstName, String userLastName, String pesel){
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.pesel = pesel;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userFirstName, user.userFirstName) && Objects.equals(userLastName, user.userLastName) && Objects.equals(pesel, user.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userFirstName, userLastName, pesel);
    }

    @Override
    public String toString() {
        return "User: " + userFirstName + " " + userLastName + " PESEL= " + pesel;
    }
}
