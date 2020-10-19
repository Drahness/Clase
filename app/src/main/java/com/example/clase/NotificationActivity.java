package com.example.clase;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NotificationActivity extends MainMenu {
    private String CHANNEL_ID = "Channel One";
    TextView textNotification;
    int notificationId = 1;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        createNotificationChannel();
        /*findViewById(R.id.button_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("holaaa");
                sendNotification();
            }
        });*/
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel() {
        CharSequence name = getString(R.string.channel_name);
        String description = getString(R.string.channel_description);
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
        channel.setDescription(description);
        NotificationManager notificationManager =
                getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    public void sendNotification(View v) {
        Intent intent = new Intent(NotificationActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pending = PendingIntent.getActivity(NotificationActivity.this,0,intent,0);
        String text = getString(R.string.notification_content);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,CHANNEL_ID);
        mBuilder.setSmallIcon(R.drawable.alarm)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(text)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ieseljust))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pending)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(NotificationActivity.this);

        notificationManagerCompat.notify(notificationId,mBuilder.build());
    }
}