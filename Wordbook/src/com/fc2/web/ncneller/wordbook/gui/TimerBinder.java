package com.fc2.web.ncneller.wordbook.gui;

import android.os.Binder;

final class TimerBinder extends Binder {
	private TimerService ser;
	TimerBinder(TimerService ser)
	{
		this.ser=ser;
	}
	TimerService getService()
	{
		return ser;
	}
}
