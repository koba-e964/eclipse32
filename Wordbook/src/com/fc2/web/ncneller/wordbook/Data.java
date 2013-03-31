package com.fc2.web.ncneller.wordbook;

import java.util.Scanner;

import android.util.Log;

public final class Data {

	public static WordDataBase database;
	public  static boolean init=false;
	public static void init(String... wrds)
	{
		if(init)return;
		try
		{
			database=new WordDataBase();
		}
		catch(Exception x)
		{
			error(x,"new");
		}
		for(String tmp : wrds)
		{
			try
			{
				database.regist(new Scanner(tmp));
				Log.d(Data.class.getName(), "read");
			}	
			catch(Exception x)
			{
				error(x,"regist,new Scanner()");
			}
		}
		init=true;
	}
	public static WordEntry get(int index)
	{
		return database.get(index);
	}
	public static int size()
	{
		return database.size();
	}
	private static void error(Exception x,String xtra)
	{
		Log.d(Data.class.getName(),"Exception "+x+xtra);
	}
}
