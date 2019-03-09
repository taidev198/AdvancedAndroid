package com.example.advancedandroid.firebase;

/**
 * Created by superme198 on 06,March,2019
 * in AdvancedAndroid.
 */
public class User {

    public String username;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
