package com.fc2.web.ncneller.wordbook.cui;

import java.util.*;

public class State {
	static int scrnum;//‰æ–Ê”Ô†
	static List<Screen> screens;
	static
	{
		scrnum=0;//initial
		screens=new ArrayList<Screen>(10);
		screens.add(new Screen0());
		screens.add(new Screen1());
		screens.add(new Screen2());
	}
	public static Screen current()
	{
		return screens.get(scrnum);
	}
	public static void setScreen(int num)
	{
		scrnum=num;
	}
}
