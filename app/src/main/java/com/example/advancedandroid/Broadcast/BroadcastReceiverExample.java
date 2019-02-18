package com.example.advancedandroid.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class BroadcastReceiverExample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (TelephonyManager.EXTRA_INCOMING_NUMBER.equals(intent.getAction())){
//            boolean noConnect = intent.getBooleanExtra(
//                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
//            );
//            if (noConnect)
//            Toast.makeText(context, "Disconnected ", Toast.LENGTH_SHORT).show();
//            else Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "Incoming phone", Toast.LENGTH_SHORT).show();
        }

//        if ("com.example.EXAMPLE_ACTION".equals(intent.getAction())){
//            String receivedText = intent.getStringExtra("com.example.EXTRA_TEXT");
//            Toast.makeText(context, receivedText, Toast.LENGTH_SHORT).show();
//        }
    }
}
