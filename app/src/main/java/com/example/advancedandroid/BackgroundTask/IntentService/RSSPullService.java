package com.example.advancedandroid.BackgroundTask.IntentService;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.example.advancedandroid.R;

import static com.example.advancedandroid.BackgroundTask.IntentService.App.CHANNEL_ID;

/**
 * Created by superme198 on 09,March,2019
 * in AdvancedAndroid.
 */
public class RSSPullService extends IntentService {

private static final String TAG = "RSSPullService";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public RSSPullService(String name) {
        super("RSSPullService");
        setIntentRedelivery(false);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Notification notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("Example IntentService")
                    .setContentText("hello world")
                    .setSmallIcon(R.drawable.notification_icon)
                    .build();
            startForeground(1, notification);
        }
    }

    @Override
    protected void onHandleIntent( Intent workIntent) {
        Log.d(TAG, "onHandleIntent: ");
    // Gets data from the incoming Intent
        String dataString = workIntent.getDataString();

        // Do work here, based on the contents of dataString

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
