package com.fc2.web.ncneller.wordbook.gui;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public class TimerServCon implements ServiceConnection
{
	private final Activity4 activity4;
	/*
	 * if this connection is established
	 */
	private boolean bound=false;
	/**
	 * @param activity4
	 */
	TimerServCon(Activity4 activity4) {
		this.activity4 = activity4;
	}
	private TimerService timerServ;
	private final String TAG=TimerServCon.class.getName();
	@Override
	public void onServiceConnected(ComponentName name, IBinder binder) {
		Log.d(TAG,"TimerServCon.onServiceConnected()");
		bound=false;
		TimerBinder tb=(TimerBinder) binder;
		timerServ=tb.getService();
		timerServ.registerActivity(this.activity4);
		bound=true;
		activity4.newQuestion();
	}
	public synchronized boolean isBound()
	{
		return bound;
	}
	@Override
	public void onServiceDisconnected(ComponentName name) {
		Log.d(TAG,"onServiceDisconnected()");
		timerServ=null;
		bound=false;
	}
	public void startCount()
	{
		Log.d(TAG,"startCount()");
		this.timerServ.startCount();
	}
	public void stopCount()
	{
		if(timerServ!=null)
			this.timerServ.stopCount();
	}
}