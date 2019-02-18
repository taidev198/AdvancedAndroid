package com.example.advancedandroid;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;

import com.example.advancedandroid.Broadcast.BroadcastReceiverExample;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiverExample broadcastReceiverExample = new BroadcastReceiverExample();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BOOT_COMPLETED);
//        registerReceiver(broadcastReceiverExample, intentFilter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(TelephonyManager.EXTRA_INCOMING_NUMBER);
        registerReceiver(broadcastReceiverExample, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiverExample);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  unregisterReceiver(broadcastReceiverExample);
    }
}
