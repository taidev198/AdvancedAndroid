package com.example.advancedandroid.Thread;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.advancedandroid.R;

public class SimpleThread extends AppCompatActivity implements Runnable{
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_thread);
        button = findViewById(R.id.button);
        Thread thread = new Thread(this);
        thread.start();
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
