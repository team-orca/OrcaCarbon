package com.example.yagizozbek.orcacarbon;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Admin on 4.05.2016.
 */
public class MyService extends Service {
    private static final String TAG = MyService.class.getSimpleName();
    Updater myUpdater;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myUpdater = new Updater();
        Log.d(TAG,"onCreate'd");
    }

    @Override
    public  synchronized int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStart'd");
        if(!myUpdater.isRunning)
            myUpdater.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public synchronized void onDestroy() {
        super.onDestroy();
        if(myUpdater.isRunning)
            myUpdater.interrupt();
        Log.d(TAG, "onDestryon'd");
    }
    private class Updater extends Thread{
        private static final long DELAY = 10000;
        private boolean isRunning=false;
        public Updater()
        {
            super("Updater");
        }
        @Override
        public synchronized void start() {
            super.start();
            isRunning=true;
        }

        @Override
        public void interrupt() {
            super.interrupt();
            isRunning=false;
        }
        public void PushNotification()
        {
            NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            Notification.Builder builder = new Notification.Builder(getBaseContext());
            Intent notificationIntent = new Intent(getBaseContext(), LoginActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(getBaseContext(),0,notificationIntent,0);

            //set
            builder.setContentIntent(contentIntent);
            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setContentText("Yap bi�eler delikanl�");
            builder.setContentTitle("TODO");
            builder.setAutoCancel(true);
            builder.setDefaults(Notification.DEFAULT_ALL);

            Notification notification = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                notification = builder.build();
            }
            nm.notify((int)System.currentTimeMillis(),notification);
        }
        @Override
        public void run() {
            super.run();
            while(isRunning)
            {
                PushNotification();
                try {
                    Thread.sleep(DELAY);
                }
                catch(InterruptedException e)
                {
                    isRunning=false;
                }
            }}
    }
}