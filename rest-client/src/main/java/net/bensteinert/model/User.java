package net.bensteinert.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author bensteinert
 */
public class User {

    private final String id;
    private String userName;
    private String firstName;
    private String lastName;


    @JsonCreator
    public User(
            @JsonProperty("_id")  String id,
            @JsonProperty("userName")  String userName,
            @JsonProperty("firstName")  String firstName,
            @JsonProperty("lastName")  String lastName
    ) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }


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
