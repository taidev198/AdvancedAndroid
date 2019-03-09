package com.example.advancedandroid.firebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.advancedandroid.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by superme198 on 06,March,2019
 * in AdvancedAndroid.
 */
public class FireBaseExample extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase_layout);

        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        writeNewUser("1", "tai", " taidev198@gmail.com");
    }

    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);
        Toast.makeText(this, "added ", Toast.LENGTH_SHORT).show();
        myRef.child("users").setValue(user);
    }
}
