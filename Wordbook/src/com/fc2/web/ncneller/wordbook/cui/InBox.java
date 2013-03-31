package com.fc2.web.ncneller.wordbook.cui;

class InBox extends Comp
{
	String str;
	InBox(){
		str="";
	}
	public void action(String[] cmd)
	{
		if(cmd.length==0)
			return;
		if(cmd.length>=2 && cmd[0].equals("in"))
		{
			str+=cmd[1];
			return;
		}
		if(cmd[0].equals("del"))
		{
			str="";
			return;
		}
	}
	public String toString()
	{
		return "InBox:\""+str+"\"";
	}
}