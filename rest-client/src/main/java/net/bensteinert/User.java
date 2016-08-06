package net.bensteinert;

/**
 * @author bensteinert
 */
public class User {

    private String id;
    private String userName;
    private String firstName;
    private String lastName;


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getId() {
        return id;
    }
}
