package com.example.advancedandroid.Thread;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.advancedandroid.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SimpleThread extends AppCompatActivity implements Runnable{
    Button button;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_thread);
        button = findViewById(R.id.button);
//        Thread thread = new Thread(this);
//        thread.start();
        FirebaseApp.initializeApp(this);
         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }

    public void writeUserData(int userId, String name, String email) {

    }


    @Override
    public void run() {
            for (int i=0; i<10; i++){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                final int finalI = i;
//                button.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        button.setText(finalI);
//                    }
//                });
                final int finalI = i;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        button.setText(finalI);
                    }
                }, 1000);
            }
    }
}
