package com.fc2.web.ncneller.wordbook.gui;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class TimerService extends Service
{
	private final String TAG=TimerService.class.getName()+", this="+String.format("%x",System.identityHashCode(this));
	@Override
	public IBinder onBind(Intent intent) {
		Binder b=new TimerBinder(this);
		return b;
	}
	@Override
	public int onStartCommand(Intent intent,int flags,int startId)
	{
		//this.timer=new Timer();
		
		this.running=false;
		return START_STICKY;
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}
	public void registerActivity(Activity4 act)
	{
		this.act=act;
	}
	public void startCount()
	{
		Log.d(TAG,"startCount()");
		if(!this.running)
		{
			Log.d(TAG,"creating new Timer");
			this.timer=new Timer();
			this.timer.scheduleAtFixedRate(this.csTask(),0,10);
			this.running=true;
		}
	}
	public void stopCount()
	{
		Log.d(TAG,"stopCount()");
		if(this.running)
		{
			Log.d(TAG,"deleting Timer...");
			this.timer.cancel();
			this.timer=null;
			this.running=false;
		}
	}
	private Timer timer;
	private TimerTask csTask()
	{
		return new TimerTask() {
			@Override
			public void run() {
				if(act!=null)
					act.post(Message.obtain(null,1));
			}
		};
	}
	private Activity4 act=null;
	private boolean running;
}