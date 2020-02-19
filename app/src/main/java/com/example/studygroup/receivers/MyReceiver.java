package com.example.studygroup.receivers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.studygroup.R;

public class MyReceiver extends BroadcastReceiver {

    public static final String LOGIN_SUCCESSFULLY = "android.intent.action.LOGIN_SUCCESSFULLY";
    public static final Integer ID_NOTIFICATION_LOGIN = 999;
    public static final String CHANNEL_ID_NOTIFICATION_LOGIN = "1";

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getExtras().getString("Name");
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID_NOTIFICATION_LOGIN)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Bienvenido")
                .setContentText(name + R.string.welcome_text_notification)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(null)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(ID_NOTIFICATION_LOGIN, mBuilder.build());
    }
}
