package com.fc2.web.ncneller.wordbook;

import java.util.Hashtable;

public class WordEntry
{
	public Hashtable<String,Object> attrib;
	WordEntry()
	{
		attrib=new Hashtable<String,Object>(6);
	}
	public void add(String name,Object val)
	{
		attrib.put(name, val);
	}
	public Object get(String name)
	{
		return attrib.get(name);
	}
	public String toString()
	{
		return attrib.toString();
	}
}