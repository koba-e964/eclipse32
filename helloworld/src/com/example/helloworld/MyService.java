package com.example.helloworld;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service{
	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}
	@Override
	public void onCreate()
	{
		super.onCreate();
		Log.d(TAG, "onCreate()");
	}
	@Override
	public int onStartCommand(Intent intent,int flags,int startId)
	{
		Log.d(TAG, "onStartCommand(Intent,int,int)");
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				Log.d(TAG,"hello?");
			}
		}, 0, 3000);
		return START_STICKY;
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		timer.cancel();
		Log.d(TAG,"onDestroy()");
	}
	public final static String TAG=MyService.class.getName();
	final Timer timer=new Timer();
}
