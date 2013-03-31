package com.fc2.web.ncneller.wordbook.cui;

class But extends Comp
{
	Screen scr;
	String str;
	But(String str,Screen scr)
	{
		this.scr=scr;
		this.str=str;
	}
	public void action(String[] cmd)
	{
		if(cmd.length>=1 && cmd[0].equals("push"))
		{
			scr.action(this);
		}
	}
	public String toString()
	{
		return "But:\""+str+"\"";
	}
}