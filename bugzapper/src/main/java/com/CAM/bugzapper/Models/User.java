package com.CAM.bugzapper.Models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private boolean active;
    private String roles;

    public User() { }
    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.active = true;
        this.roles = "ROLE_USER";
    }

    public int getID() { return userID; }

    public void setID(int userID) {
        this.userID = userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "{\"id\": " + userID + ",\n" +
                "\"firstname\": \"" + firstname + "\",\n" +
                "\"lastname\": \"" + lastname + "\",\n" +
                "\"email\": \"" + username + "\"}";
    }
}
