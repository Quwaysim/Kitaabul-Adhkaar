package com.amc.astc.adhkaar.workers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.amc.astc.adhkaar.R;
import com.amc.astc.adhkaar.ui.DashboardActivity;
import com.amc.astc.adhkaar.utils.Constants;

import static com.amc.astc.adhkaar.utils.Constants.NOTIFICATION_ID;

public class DuaWorker extends Worker {

    public DuaWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        makeStatusNotification(getApplicationContext());
        return Result.success();
    }

    static void makeStatusNotification(Context context) {

        // Make a channel if necessary
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            CharSequence name = Constants.VERBOSE_NOTIFICATION_CHANNEL_NAME;
            String description = Constants.VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION;
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel =
                    new NotificationChannel(Constants.CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Add the channel
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        //Intent to open the app on tapping on the notification
        Intent notificationIntent = new Intent(context, DashboardActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(
                context,
                NOTIFICATION_ID,
                notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        // Create the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, Constants.CHANNEL_ID)
                .setSmallIcon(R.drawable.app_logo_white)
                .setContentTitle(Constants.NOTIFICATION_TITLE)
                .setContentText("Time for some Adhkaar")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[0])
                .setAutoCancel(true)
                .setContentIntent(notificationPendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        // Show the notification
        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build());
    }

}
