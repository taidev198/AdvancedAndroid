package com.example.advancedandroid;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ServiceActivity extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("started");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("stopped");
    }

    @Override

    public IBinder onBind(Intent intent) {

        return null;
    }
}
