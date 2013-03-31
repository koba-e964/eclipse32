package com.fc2.web.ncneller.wordbook.cui;

public abstract class Screen
{
	abstract public Comp[] getScreenInfo();
	abstract public void action(Comp c);
	abstract public void command(int num,String[] args);
}