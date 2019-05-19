package com.example.notepad;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class RemindActionBroadcast extends BroadcastReceiver {
    public static int id=0;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {

        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        Notification.Builder mbuilder=new Notification.Builder(context);
        mbuilder.setContentTitle(intent.getStringExtra("title"));//设置通知栏标题
        mbuilder.setContentText(intent.getStringExtra("context"));//设置通知栏内容
        mbuilder.setSmallIcon(R.mipmap.ic_launcher);//设置小图标
        mbuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher));//设置大图标
        mbuilder.setContentIntent(pendingIntent);//设置点击跳转的Intent，因为没有设置uri，所以跳转为空
        mbuilder.setAutoCancel(true);//点击之后消失
        Notification notification=mbuilder.build();
        notificationManager.notify(id++,notification);//能够传送多条消息
    }
}