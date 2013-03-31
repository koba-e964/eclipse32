package com.fc2.web.ncneller.wordbook.cui;

class TextBox extends Comp
{
	String str;
	public TextBox(String str)
	{
		this.str=str;
	}
	public void action(String[] cmd)
	{
		return;
	}
	public String toString()
	{
		return "TextBox:\""+this.str+"\"";
	}
}