package com.example.game2048;


import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotifyBroadcast extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent NotifyIntent = new Intent(context, MainActivity.class);
        NotifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingNotifyIntent = PendingIntent.getActivity(context, 0, NotifyIntent, 0);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, "Channel_Notify")
                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                .setContentTitle("COME AND PLAY 2048")
                .setContentText("2048 is waiting for you!")
                .setColor(Color.parseColor("#FFE400"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                //Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingNotifyIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(NOTIFICATION_ID, notification.build());
    }

}
