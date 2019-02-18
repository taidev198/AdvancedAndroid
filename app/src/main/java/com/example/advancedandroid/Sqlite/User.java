package com.example.advancedandroid.Sqlite;

public class User {

    String username;
    String password;
    int id;

    public User(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
