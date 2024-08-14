package pl.adam;

public class User {
    private final String userFirstName;
    private final String userLastName;
    private final String userID;

    public User(String userFirstName, String userLastName, String userID){
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userID = userID;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "User: " + userFirstName + " " + userLastName + " ID= " + userID;
    }
}
